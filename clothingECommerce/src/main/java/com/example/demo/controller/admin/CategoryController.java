package com.example.demo.controller.admin;

import com.example.demo.domain.Category;
import com.example.demo.model.CategoryDto;
import com.example.demo.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping(path = "admin/categories")
public class CategoryController {
    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "add")
    public String add(Model model) {
        model.addAttribute("category", new CategoryDto());
        return "admin/categories/addOrEdit";
    }

    @PostMapping(path = "saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model, CategoryDto dto) {
        Category entity = new Category();
        BeanUtils.copyProperties(dto, entity);

        categoryService.save(entity);
        model.addAttribute("message", "Save succeed");
        return new ModelAndView("redirect:/admin/categories/list", model);
    }


    @GetMapping("edit/{id}")
    public ModelAndView editCategory(ModelMap model, @PathVariable("id") Long id) {
        Optional<Category> opt = categoryService.findById(id);
        CategoryDto dto = new CategoryDto();
        if (opt.isPresent()) {
            Category entity = opt.get();

            dto.setEdit(true);

            model.addAttribute("category", dto);
            BeanUtils.copyProperties(entity, dto);
            return new ModelAndView("admin/categories/addOrEdit", model);
        }
        model.addAttribute("message", "Category dose not exist");
        return new ModelAndView("forward:/admin/categories/list", model);
    }

//    @GetMapping("list")
//    public String searchCategory(ModelMap model,
//                                 @RequestParam(value = "name", required = false) String name) {
//        List<Category> list = categoryService.findByNameContaining(name);
//        if (list.isEmpty()) {
//            list = categoryService.findAll();
//        }
//        model.addAttribute("categories", list);
//        return "admin/categories/list";
//    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteCategory(ModelMap model,
                                       @PathVariable("id") Long id) {
        boolean idExist = categoryService.existsById(id);
        if (idExist) {
            categoryService.deleteById(id);
            model.addAttribute("message", "Category has been deleted!");
            return new ModelAndView("forward:/admin/categories/list", model);
        }
        model.addAttribute("message", "Category does not exist.");
        return new ModelAndView("forward:/admin/categories/list", model);
    }

    @GetMapping("list")
    public String searchAtListCategory(Model model,
                                       @RequestParam(value = "name", required = false) String name,
                                       @RequestParam(value = "page") Optional<Integer> page)  {
        int currentPage = page.orElse(0);

        //B1: Pageable
        Pageable pageable = PageRequest.of(currentPage, 5);
        Page<Category> resultPage = null;
        if (!StringUtils.hasText(name)) {
            resultPage = categoryService.findAll(pageable);
            model.addAttribute("categories", resultPage);
        } else {
            resultPage = categoryService.findByNameContaining(name, pageable);
            model.addAttribute("categories", resultPage);
        }
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", resultPage.getTotalPages());
        model.addAttribute("totalItems", resultPage.getTotalElements());
        return "admin/categories/list";
    }

//    @GetMapping("list/find")
//    public List<Category> findCategory(@RequestParam(value = "name", required = false) String name){
//        List<Category> list = categoryService.findByNameContaining(name);
//        if (list.isEmpty()){
//            list = categoryService.findAll();
//        }
//        return list;
//    }


//    @GetMapping("addAll")
//    public List<Category> list(){
//        List<Category> list = categoryService.findAll();
//        return list;
//    }

}
