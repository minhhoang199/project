package com.example.demo.controller.admin;

import com.example.demo.domain.Category;
import com.example.demo.model.CategoryDto;
import com.example.demo.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "admin/categories")
public class CategoryController {
    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "add")
    public String add(Model model){
        model.addAttribute("category", new CategoryDto());
        return "admin/categories/addOrEdit";
    }

    @PostMapping(path = "saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model, CategoryDto dto){
        Category entity = new Category();
        BeanUtils.copyProperties(dto, entity);

        categoryService.save(entity);
        model.addAttribute("message", "Save succeed");
        return new ModelAndView("redirect:/admin/categories/list", model);
    }

    @GetMapping("list")
    public String list(ModelMap model){
        List<Category> list = categoryService.findAll();

        model.addAttribute("categories", list);

        return "admin/categories/list";
    }

    @GetMapping("edit/{id}")
    public ModelAndView editCategory(ModelMap model, @PathVariable("id") Long id){
        Optional<Category> opt = categoryService.findById(id);
        CategoryDto dto = new CategoryDto();
        if (opt.isPresent()){
            Category entity = opt.get();

            dto.setEdit(true);

            model.addAttribute("category", dto);
            BeanUtils.copyProperties(entity, dto);
            return new ModelAndView("admin/categories/addOrEdit", model);
        }
        model.addAttribute("message", "Category dose not exist");
        return new ModelAndView("redirect:/admin/categories/list", model);
    }


//    @GetMapping("addAll")
//    public List<Category> list(){
//        List<Category> list = categoryService.findAll();
//        return list;
//    }

}
