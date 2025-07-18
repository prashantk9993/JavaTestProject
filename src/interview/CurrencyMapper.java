package interview;

import java.util.HashMap;
import java.util.Map;

public class CurrencyMapper {


    public static Map<String, Integer> countryCurrencyMapper = Map.of("US",1,"IND",86,"NEP",200);

    public static Integer getPrize(String countryCode, Integer weight){
        return countryCurrencyMapper.get(countryCode)*weight;
    }
}
