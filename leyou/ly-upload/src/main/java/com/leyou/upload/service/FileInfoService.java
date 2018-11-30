package com.leyou.upload.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyou.common.vo.PageBean;
import com.leyou.upload.entity.FileInfo;
import com.leyou.upload.mapper.FileInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName FileInfoService
 * @Description 文件信息服务类
 * @Author wq
 * @Date 2018/11/30 15:42
 * @Version 1.0.0
 */
@Service
public class FileInfoService {

    @Autowired
    private FileInfoMapper fileInfoMapper;

    /**
     * 文件列表分页
     * @param page
     * @param rows
     * @param queryString
     * @return
     */
    public Object getFileInfoPage(Integer page, Integer rows, String queryString) {
        PageHelper.startPage(page, rows);
        Example example = new Example(FileInfo.class);
        if (StringUtils.isNotBlank(queryString)){
            example.createCriteria().andLike("fileName", "%"+queryString+"%").orLike("fileType","%"+queryString+"%");
        }
        Page<FileInfo> pageInfo = (Page<FileInfo>) fileInfoMapper.selectByExample(example);
        return new PageBean<FileInfo>(pageInfo.getTotal(), pageInfo.getResult());
    }

    /**
     * 根据上传ID查询对应的文件列表
     * @param objectId
     * @return
     */
    public Object getFileListByObjectId(Long objectId) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setObjectId(objectId);
        List<FileInfo> fileInfoList = fileInfoMapper.select(fileInfo);
        return fileInfoList;
    }


    /**
     * 新增
     * @param fileInfo
     * @return
     */
    public Boolean insertFileInfo(FileInfo fileInfo){
        return fileInfoMapper.insert(fileInfo) > 0;
    }

    /**
     * 删除文件列表
     * @FIXME 要对应删除文件系统的文件(包括源文件和缩略图)
     * @param objectId
     * @return
     */
    public Object deleteFileListByObjectId(Long objectId) {
        //TODO 删除文件系统的文件
        FileInfo fileInfo  = new FileInfo();
        fileInfo.setObjectId(objectId);
        return  fileInfoMapper.delete(fileInfo);
    }
}
