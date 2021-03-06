package com.jhbim.bimvr.dao.mapper;

import com.jhbim.bimvr.dao.entity.pojo.ResDrawing;

import java.util.List;

public interface ResDrawingMapper {
    int deleteByPrimaryKey(Integer resPictureId);

    int insert(ResDrawing record);

    int insertSelective(ResDrawing record);

    ResDrawing selectByPrimaryKey(Integer resPictureId);

    int updateByPrimaryKeySelective(ResDrawing record);

    int updateByPrimaryKey(ResDrawing record);

    ResDrawing getOneRes(ResDrawing resDrawing);

    //展示所有的图纸
    List<ResDrawing> getAll(ResDrawing resDrawing);
    //根据项目id查询该项目有没有图纸
    List<ResDrawing> getprojectids(Long projectid);
}