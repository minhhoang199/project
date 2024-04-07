import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class testChunks {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\DELL\\Documents\\token.docx"; // Path to your file
        int maxChunkSizeMB = 1; // Maximum chunk size in megabytes

        try {
            List<byte[]> fileChunks = chunkFile(filePath, maxChunkSizeMB);
            System.out.println("File split into " + fileChunks.size() + " chunks.");
            for (int i = 0; i < fileChunks.size(); i++) {
                // Process or transfer each chunk
                byte[] chunk = fileChunks.get(i);
                System.out.println("Chunk " + (i + 1) + " Size: " + chunk.length);
            }

            // Do something with the chunks, like sending over a network or storing in a database
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<byte[]> chunkFile(String filePath, int maxChunkSizeMB) throws IOException {
        List<byte[]> chunks = new ArrayList<>();
        byte[] buffer = new byte[maxChunkSizeMB * 1024]; // 5MB buffer

        try (InputStream inputStream = new FileInputStream(filePath)) {
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) > 0) {
                if (bytesRead < buffer.length) {
                    // If the last read did not fill the buffer, create a smaller chunk
                    byte[] lastChunk = new byte[bytesRead];
                    System.arraycopy(buffer, 0, lastChunk, 0, bytesRead);
                    chunks.add(lastChunk);
                } else {
                    // If the buffer is filled, add it as a chunk
                    chunks.add(buffer);
                    buffer = new byte[maxChunkSizeMB * 1024]; // Reinitialize buffer
                }
            }
        }

        return chunks;
    }
}
