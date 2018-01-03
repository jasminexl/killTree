package dongxin.flowbilling.channel.mapper;


        import dongxin.flowbilling.channel.entity.byjChannel;

        import java.util.Map;

public interface byjChannelMapper {

    byjChannel selectByChcode(Map<String, String> map);

}