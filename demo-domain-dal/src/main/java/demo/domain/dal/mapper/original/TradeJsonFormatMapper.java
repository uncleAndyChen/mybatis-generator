package demo.domain.dal.mapper.original;

import demo.domain.model.entity.TradeJsonFormat;
import demo.domain.model.entity.TradeJsonFormatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeJsonFormatMapper {
    long countByExample(TradeJsonFormatExample example);

    int deleteByExample(TradeJsonFormatExample example);

    int deleteByPrimaryKey(Integer tradeJFID);

    int insert(TradeJsonFormat record);

    int insertSelective(TradeJsonFormat record);

    List<TradeJsonFormat> selectByExampleWithBLOBs(TradeJsonFormatExample example);

    List<TradeJsonFormat> selectByExample(TradeJsonFormatExample example);

    TradeJsonFormat selectByPrimaryKey(Integer tradeJFID);

    int updateByExampleSelective(@Param("record") TradeJsonFormat record, @Param("example") TradeJsonFormatExample example);

    int updateByExampleWithBLOBs(@Param("record") TradeJsonFormat record, @Param("example") TradeJsonFormatExample example);

    int updateByExample(@Param("record") TradeJsonFormat record, @Param("example") TradeJsonFormatExample example);

    int updateByPrimaryKeySelective(TradeJsonFormat record);

    int updateByPrimaryKeyWithBLOBs(TradeJsonFormat record);

    int updateByPrimaryKey(TradeJsonFormat record);
}