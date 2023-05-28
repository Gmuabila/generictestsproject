package genericclasses.functionalInterfaces.userdefinedfunctionalInterface;

public class UserDefinedFunctionalClass implements UserDefinedFInt<Long, Integer> {
    @Override
    public Integer transform(Long x) {
        x +=4;          //x = x + 4
        return Integer.valueOf(x.intValue());
    }
}
