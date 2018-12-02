package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Chapter;
import com.baizhi.cmfz.service.AlbumService;
import com.baizhi.cmfz.service.ChapterService;
import com.baizhi.cmfz.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private AlbumService albumService;

    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/selectAll")
    public @ResponseBody Map selectAll(){
        Map map=new HashMap();
        map=albumService.selectAll();
        return map;
    }

    @RequestMapping("/add")
    public @ResponseBody boolean addChapter(MultipartFile chapter, String title, String id, HttpServletRequest request){
        System.out.println(chapter+"-title-"+title+"-id-"+id);
        String realPath=request.getSession().getServletContext().getRealPath("/");
        File file=new File(realPath+"/upload");
        if(!file.exists()){
            file.mkdir();
        }

        String extension= FilenameUtils.getExtension(chapter.getOriginalFilename());
        UUID uuid=UUID.randomUUID();
        uuid.toString();
        String s=uuid.toString();
        String newName=s+"."+extension;
        try {
            chapter.transferTo(new File(file.getAbsolutePath(),newName ));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int length=FileUtil.getDuration(new File(file.getAbsolutePath()+"/"+newName));
        int mm=length/60;
        int ss=length%60;

        long size=chapter.getSize();
        double l=size/1024.0/1024.0;

        BigDecimal ll = new BigDecimal(l);
        double lll = ll.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        String llll=Double.toString(lll);
        String lengthh=mm+"分"+ss+"秒";

        int idd=Integer.parseInt(id);
        Date date=new Date();
        Chapter c=new Chapter(0,title,llll+"MB",lengthh,newName,date,idd);
        try {
            chapterService.insert(c);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @RequestMapping("/download")
    public void download(String url, String title, HttpServletRequest request, HttpServletResponse response){
        String uploadPath=request.getSession().getServletContext().getRealPath("upload");
        String path=uploadPath+"/"+url;
        //System.out.println(url+"-"+title);
        File file=new File(path);
        String fileName=file.getName();
        String extension= fileName.substring(fileName.lastIndexOf(".") + 1);

        String s=title+"."+extension;
        //System.out.println(s);

        try {
            response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(s,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("audio/mpeg");

        try {
            ServletOutputStream outputStream= response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
