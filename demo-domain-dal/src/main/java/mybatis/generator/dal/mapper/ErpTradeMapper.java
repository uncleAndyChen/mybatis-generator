package mybatis.generator.dal.mapper;

import java.util.List;
import mybatis.generator.model.entity.ErpTrade;
import mybatis.generator.model.entity.ErpTradeExample;
import org.apache.ibatis.annotations.Param;

public interface ErpTradeMapper {
    long countByExample(ErpTradeExample example);

    int deleteByExample(ErpTradeExample example);

    int deleteByPrimaryKey(Integer tradeID);

    int insert(ErpTrade record);

    int insertSelective(ErpTrade record);

    List<ErpTrade> selectByExample(ErpTradeExample example);

    ErpTrade selectByPrimaryKey(Integer tradeID);

    int updateByExampleSelective(@Param("record") ErpTrade record, @Param("example") ErpTradeExample example);

    int updateByExample(@Param("record") ErpTrade record, @Param("example") ErpTradeExample example);

    int updateByPrimaryKeySelective(ErpTrade record);

    int updateByPrimaryKey(ErpTrade record);
}