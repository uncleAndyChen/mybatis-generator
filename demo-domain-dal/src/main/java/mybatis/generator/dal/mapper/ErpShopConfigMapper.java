package mybatis.generator.dal.mapper;

import java.util.List;
import mybatis.generator.model.entity.ErpShopConfig;
import mybatis.generator.model.entity.ErpShopConfigExample;
import org.apache.ibatis.annotations.Param;

public interface ErpShopConfigMapper {
    long countByExample(ErpShopConfigExample example);

    int deleteByExample(ErpShopConfigExample example);

    int deleteByPrimaryKey(Integer ID);

    int insert(ErpShopConfig record);

    int insertSelective(ErpShopConfig record);

    List<ErpShopConfig> selectByExample(ErpShopConfigExample example);

    ErpShopConfig selectByPrimaryKey(Integer ID);

    int updateByExampleSelective(@Param("record") ErpShopConfig record, @Param("example") ErpShopConfigExample example);

    int updateByExample(@Param("record") ErpShopConfig record, @Param("example") ErpShopConfigExample example);

    int updateByPrimaryKeySelective(ErpShopConfig record);

    int updateByPrimaryKey(ErpShopConfig record);
}