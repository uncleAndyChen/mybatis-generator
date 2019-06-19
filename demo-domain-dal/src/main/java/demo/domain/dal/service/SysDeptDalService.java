package demo.domain.dal.service;

import common.lib.application.BeanTools;
import demo.domain.dal.mapper.original.SysDeptMapper;
import demo.domain.model.entity.SysDept;
import demo.domain.model.entity.SysDeptExample;

import java.util.List;

public class SysDeptDalService {
    private static SysDeptMapper sysDeptMapper = (SysDeptMapper) BeanTools.getBean(SysDeptMapper.class);

    public static List<SysDept> getSysDeptList() {
        SysDeptExample example = new SysDeptExample();
        example.or().andStatusEqualTo(1);
        return sysDeptMapper.selectByExample(example);
    }
}
