package demo.domain.dal.mapper.original;

import demo.domain.model.entity.SysMenuAction;
import demo.domain.model.entity.SysMenuActionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMenuActionMapper {
    long countByExample(SysMenuActionExample example);

    int deleteByExample(SysMenuActionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysMenuAction record);

    int insertSelective(SysMenuAction record);

    List<SysMenuAction> selectByExample(SysMenuActionExample example);

    SysMenuAction selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysMenuAction record, @Param("example") SysMenuActionExample example);

    int updateByExample(@Param("record") SysMenuAction record, @Param("example") SysMenuActionExample example);

    int updateByPrimaryKeySelective(SysMenuAction record);

    int updateByPrimaryKey(SysMenuAction record);
}