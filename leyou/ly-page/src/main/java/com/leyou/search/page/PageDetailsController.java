package com.leyou.search.page;

import com.leyou.search.api.ItemApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName PageDetailsController
 * @Description TODO
 * @Author wq
 * @Date 2019/1/12 10:11
 * @Version 1.0.0
 */
@Controller
@RequestMapping("/page-detail")
public class PageDetailsController {

    @Autowired
    private ItemApi itemApi;

    @RequestMapping("/to-index")
    public ModelAndView toInde(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("user", "张三");
        return modelAndView;
    }
}
