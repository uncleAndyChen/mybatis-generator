package demo.domain.dal.mapper.original;

import demo.domain.model.entity.ErpShopConfig;
import demo.domain.model.entity.ErpShopConfigExample;
import java.util.List;
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