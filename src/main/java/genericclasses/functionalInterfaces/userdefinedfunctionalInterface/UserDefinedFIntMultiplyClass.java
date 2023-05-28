package genericclasses.functionalInterfaces.userdefinedfunctionalInterface;

public class UserDefinedFIntMultiplyClass implements UserDefinedFInt<Double, Long>{
    @Override
    public Long transform(Double d){
        d *=d;          //d = d * d
        return Long.valueOf(d.longValue());
    }
}
