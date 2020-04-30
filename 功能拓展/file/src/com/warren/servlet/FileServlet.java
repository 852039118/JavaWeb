package com.warren.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws javax.servlet.ServletException, IOException {
        //判断上传的表单是普通表单还是带文件的表单
        if (ServletFileUpload.isMultipartContent(req)){
            return; //若是普通表单，终止运行
        }
        try {
        //创建上传文件的保存路轻，建议在WEB-INF路轻下，安全， 用户无法直接访问上传的文件
        String uploadPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File uploadFile = new File(uploadPath);
        if (!uploadFile.exists()){
            uploadFile.mkdir(); //如果目录不存在，就创建这个目录
        }

        //缓存，临时文件
        //临时路径，如果文件超过了预期的大小，我们就会把它放在一个临时的文件中，过几天自动删除，或者提醒用户转存为永久
        String tmpPath = this.getServletContext().getRealPath("/WEB-INF/tmp");
        File tmpFile = new File(tmpPath);
        if (!tmpFile.exists()){
            tmpFile.mkdir(); //如果目录不存在，就创建这个目录
        }

        //处理上传的文件，一般都面要题过滋来获敬，我们以w使request . getInputstream(),原生态的义件1:传流获收， /分麻烟
        //P!是我们都建议使川Apache的文件1:传组件米实现，common-fileuplood, 它需要依腴厂commons-io组件:

        //1. 处理文件上传路径或大小限制的
        DiskFileItemFactory factory = new DiskFileItemFactory();

        //2. 获取ServletFileUpload
        ServletFileUpload upload = new ServletFileUpload(factory);

        //3. 处理上传的文件
        //把前端请求解析，封装成一个fileItem对象
            List<FileItem> fileItems = upload.parseRequest(req);
            //fileItem ：每一个表单对象
            for (FileItem fileItem : fileItems){
                //判断上传的表单是普通表单还是带文件的表单
                if (fileItem.isFormField()){
                    //getFieldName是获取前端表单控件的name
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
                    System.out.println("name:" + value);
                }else {//文件
                    //处理文件
                    String uploadFileName = fileItem.getName();
                    //可能存在文件名不合法的情况
                    if (uploadFileName == null || uploadFileName.trim().equals("")){
                        continue;
                    }
                    //获取上传的文件名
                    String fileName = uploadFileName.substring(0,uploadFileName.lastIndexOf("/") + 1);
                    //获取上传的后缀
                    String fileExtName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
                    /*
                       如果文件后缀名fileExtName不是我们所需要的
                        就直按return，不处理， 告诉用户文件类型不对。
                    */
                    //直接使用UUID生成唯一的通用识别码，保证文件名唯一

                    //网络传输中的东西，都需要序列化
                    //pojo，实体类，如果想在多个电脑上运行， 传输===>需要把对象序列化
                    //implement Serializable    :标记接口

                    //存放地址
                    //文件传输
                }
            }







        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws javax.servlet.ServletException, IOException {
        doPost(req,resp);
    }
}
