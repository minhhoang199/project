package com.tm.j10.service;

import com.tm.j10.domain.Media;
import com.tm.j10.repository.MediaRepository;
import com.tm.j10.web.rest.vm.MediaVM;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MediaService {
    private MediaRepository mediaRepository;

    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    private void validateString(String str) {
        if (str == null ||
            str.length() == 0) throw new RuntimeException("Invalid string: " + str);
    }

    public void addMedia(MediaVM mediaVM) {
        if (mediaVM != null) {
            String mediaAlt = mediaVM.getMediaAlt();
            validateString(mediaAlt);

            String mediaDes = mediaVM.getMediaDescription();
            validateString(mediaDes);

            String mediaCaption = mediaVM.getMediaCaption();
            validateString(mediaCaption);

            Media newMedia = new Media();

            MultipartFile file = mediaVM.getFile();
            if (!file.isEmpty()) {
                try {
                    String realPathToUploadMedias = "E:\\uploaded\\";

                    if (!new File(realPathToUploadMedias).exists()) {
                        new File(realPathToUploadMedias).mkdirs();
                    }
                    LocalDateTime now = LocalDateTime.now();
                    String pattern = "yyyyMMdd hh-mm-ss";

                    String uploadedFileName = file.getName() + now.format(DateTimeFormatter.ofPattern(pattern));
                    String newPath = realPathToUploadMedias + uploadedFileName;
                    File newFileObject = new File(newPath);
                    file.transferTo(newFileObject);

                    newMedia.setMediaURL(newPath);
                    newMedia.setMediaName(uploadedFileName);
                    newMedia.setMediaType(file.getContentType());
                    newMedia.setUploadMonth(now.getMonth() + "");
                    newMedia.setUploadYear(now.getYear() + "");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            newMedia.setMediaAlt(mediaAlt);
            newMedia.setMediaCaption(mediaCaption);
            newMedia.setMediaDescription(mediaDes);

            this.mediaRepository.save(newMedia);
        }
    }
}
