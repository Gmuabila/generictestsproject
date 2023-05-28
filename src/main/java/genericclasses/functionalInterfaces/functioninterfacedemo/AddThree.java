package genericclasses.functionalInterfaces.functioninterfacedemo;

import java.util.function.Function;

public class AddThree implements Function<Long, Integer> {
    @Override
    public Integer apply(Long l){
          l += 3;  //l = l + 3;
//        Long l = 123L;
//        Integer correctButComplicated = Integer.valueOf(l.intValue());
//        Integer withBoxing = l.intValue();
//        Integer terrible = (int) (long) l;
        return Integer.valueOf(l.intValue());
//        Integer i = (l.intValue());
//        return i;
    }
}
