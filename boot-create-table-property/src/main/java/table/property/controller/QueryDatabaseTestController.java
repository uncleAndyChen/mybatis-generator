package table.property.controller;

import demo.domain.dal.service.SysDeptDalService;
import demo.domain.model.entity.SysDept;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QueryDatabaseTestController {
    @RequestMapping("/getSysDeptList")
    public List<SysDept> getSysDeptList(){
        return SysDeptDalService.getSysDeptList();
    }
}
