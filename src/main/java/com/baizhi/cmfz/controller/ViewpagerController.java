package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Viewpager;
import com.baizhi.cmfz.service.ViewpagerService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.View;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/viewpager")
public class ViewpagerController {
    @Autowired
    private ViewpagerService viewpagerService;

    @RequestMapping("/selectAll")
    public @ResponseBody Map selectAll(int page,int rows){
        Map map=new HashMap();
        map=viewpagerService.selectByStartAndEnd(page,rows);
        return map;
    }

    @RequestMapping("/update")
    public @ResponseBody boolean update(int id,String status){
        //System.out.println(id+"-"+status);
        try {
            viewpagerService.update(id, status);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping("/delete")
    public @ResponseBody boolean delete(int id){
        //System.out.println(id+"-"+status);
        try {
            viewpagerService.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping("/add")
    public @ResponseBody boolean add(String title,String desc,String status, MultipartFile myImg, HttpServletRequest request){
        String realPath=request.getSession().getServletContext().getRealPath("/");
        File file=new File(realPath+"/img");
        String extension= FilenameUtils.getExtension(myImg.getOriginalFilename());
        UUID uuid=UUID.randomUUID();
        String s=uuid.toString();
        String newNane=s+"."+extension;
        //System.out.println(file.getAbsolutePath());
        Date date=new Date();
        Viewpager viewpager=new Viewpager();
        viewpager.setTitle(title);
        viewpager.setDesc(desc);
        viewpager.setStatus(status);
        viewpager.setDate(date);
        viewpager.setImgPath(newNane);
        viewpager.setId(0);
        System.out.println(viewpager);
        try {
            myImg.transferTo(new File(file.getAbsolutePath(),newNane));
            viewpagerService.insert(viewpager);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
