package mybatis.generator.dal.mapper;

import java.util.List;
import mybatis.generator.model.entity.ShopConfig;
import mybatis.generator.model.entity.ShopConfigExample;
import org.apache.ibatis.annotations.Param;

public interface ShopConfigMapper {
    long countByExample(ShopConfigExample example);

    int deleteByExample(ShopConfigExample example);

    int deleteByPrimaryKey(Integer ID);

    int insert(ShopConfig record);

    int insertSelective(ShopConfig record);

    List<ShopConfig> selectByExample(ShopConfigExample example);

    ShopConfig selectByPrimaryKey(Integer ID);

    int updateByExampleSelective(@Param("record") ShopConfig record, @Param("example") ShopConfigExample example);

    int updateByExample(@Param("record") ShopConfig record, @Param("example") ShopConfigExample example);

    int updateByPrimaryKeySelective(ShopConfig record);

    int updateByPrimaryKey(ShopConfig record);
}