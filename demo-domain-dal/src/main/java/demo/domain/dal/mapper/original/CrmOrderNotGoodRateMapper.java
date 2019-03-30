package demo.domain.dal.mapper.original;

import demo.domain.model.entity.CrmOrderNotGoodRate;
import demo.domain.model.entity.CrmOrderNotGoodRateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmOrderNotGoodRateMapper {
    long countByExample(CrmOrderNotGoodRateExample example);

    int deleteByExample(CrmOrderNotGoodRateExample example);

    int deleteByPrimaryKey(Integer orderNGRID);

    int insert(CrmOrderNotGoodRate record);

    int insertSelective(CrmOrderNotGoodRate record);

    List<CrmOrderNotGoodRate> selectByExample(CrmOrderNotGoodRateExample example);

    CrmOrderNotGoodRate selectByPrimaryKey(Integer orderNGRID);

    int updateByExampleSelective(@Param("record") CrmOrderNotGoodRate record, @Param("example") CrmOrderNotGoodRateExample example);

    int updateByExample(@Param("record") CrmOrderNotGoodRate record, @Param("example") CrmOrderNotGoodRateExample example);

    int updateByPrimaryKeySelective(CrmOrderNotGoodRate record);

    int updateByPrimaryKey(CrmOrderNotGoodRate record);
}