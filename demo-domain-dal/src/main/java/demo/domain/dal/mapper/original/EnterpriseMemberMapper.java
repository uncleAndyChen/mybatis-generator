package demo.domain.dal.mapper.original;

import demo.domain.model.entity.EnterpriseMember;
import demo.domain.model.entity.EnterpriseMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnterpriseMemberMapper {
    long countByExample(EnterpriseMemberExample example);

    int deleteByExample(EnterpriseMemberExample example);

    int deleteByPrimaryKey(Long memberID);

    int insert(EnterpriseMember record);

    int insertSelective(EnterpriseMember record);

    List<EnterpriseMember> selectByExample(EnterpriseMemberExample example);

    EnterpriseMember selectByPrimaryKey(Long memberID);

    int updateByExampleSelective(@Param("record") EnterpriseMember record, @Param("example") EnterpriseMemberExample example);

    int updateByExample(@Param("record") EnterpriseMember record, @Param("example") EnterpriseMemberExample example);

    int updateByPrimaryKeySelective(EnterpriseMember record);

    int updateByPrimaryKey(EnterpriseMember record);
}