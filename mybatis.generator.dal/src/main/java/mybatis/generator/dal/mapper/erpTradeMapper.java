package mybatis.generator.dal.mapper;

import java.util.List;
import mybatis.generator.model.entity.erpTrade;
import mybatis.generator.model.entity.erpTradeExample;
import org.apache.ibatis.annotations.Param;

public interface erpTradeMapper {
    long countByExample(erpTradeExample example);

    int deleteByExample(erpTradeExample example);

    int deleteByPrimaryKey(Integer tradeID);

    int insert(erpTrade record);

    int insertSelective(erpTrade record);

    List<erpTrade> selectByExample(erpTradeExample example);

    erpTrade selectByPrimaryKey(Integer tradeID);

    int updateByExampleSelective(@Param("record") erpTrade record, @Param("example") erpTradeExample example);

    int updateByExample(@Param("record") erpTrade record, @Param("example") erpTradeExample example);

    int updateByPrimaryKeySelective(erpTrade record);

    int updateByPrimaryKey(erpTrade record);
}