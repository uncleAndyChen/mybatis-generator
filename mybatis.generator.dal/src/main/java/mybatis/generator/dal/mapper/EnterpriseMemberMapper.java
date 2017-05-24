package mybatis.generator.dal.mapper;

import java.util.List;
import mybatis.generator.model.entity.EnterpriseMember;
import mybatis.generator.model.entity.EnterpriseMemberExample;
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