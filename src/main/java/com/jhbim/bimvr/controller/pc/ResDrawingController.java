package com.jhbim.bimvr.controller.pc;

import com.jhbim.bimvr.dao.entity.pojo.ResDrawing;
import com.jhbim.bimvr.dao.entity.vo.Result;
import com.jhbim.bimvr.dao.mapper.ResDrawingMapper;
import com.jhbim.bimvr.system.enums.ResultStatusCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/${version}/pcreddrawing")
public class ResDrawingController {

    @Resource
    ResDrawingMapper drawingMapper;

    /**
     * 根据模型类型和项目id 所属公司的id查询所有的图纸
     * @param modelid 模型id
     * @param projectid 项目id
     * @param request
     */
    @GetMapping("/getAll/{modelid}/{projectid}/{drawtypeid}")
    public Result getall(@PathVariable String modelid,@PathVariable Long projectid,@PathVariable int drawtypeid, HttpServletRequest request){
        ServletContext appiltion =request.getSession().getServletContext();
        Long companyid= (Long) appiltion.getAttribute("User_CompanyId");
        ResDrawing resDrawing=new ResDrawing();
        resDrawing.setModelId(modelid);
        resDrawing.setProjectId(projectid);
        resDrawing.setCompanyId(companyid);
        resDrawing.setDrawType(drawtypeid);
        System.out.println(modelid);
        System.out.println(projectid);
        System.out.println(drawtypeid);
        return new Result(ResultStatusCode.OK, drawingMapper.getAll(resDrawing));
    }

    /**
     * 点击图纸显示相对应的图纸信息
     * @param id 图纸id
     * @return
     */
    @GetMapping("/selectByPrimaryKey/{id}")
    public Result selectByPrimaryKey(@PathVariable int id){
        return new Result(ResultStatusCode.OK, drawingMapper.selectByPrimaryKey(id));
    }

    /**
     * 根据项目id查询该项目有没有图纸
     * @param id 项目id
     * @return
     */
    @GetMapping("/getprojectids/{id}")
    public Result getprojectids(@PathVariable Long id){
        return new Result(ResultStatusCode.OK,drawingMapper.getprojectids(id));
    }

}
