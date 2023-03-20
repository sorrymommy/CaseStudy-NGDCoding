package com.sorrymommy.amos;

import com.sorrymommy.amos.model.normal.MetarItem;
import com.sorrymommy.amos.parser.normal.MetarParser;
import com.sorrymommy.amos.types.AMOSApiType;
import com.sorrymommy.amos.types.AMOSApiVersion;

import java.util.List;

public class AMOSUtil {


    public class NormalMetar{
        private com.sorrymommy.amos.parser.normal.MetarParser parser = new MetarParser();
        private NormalMetar(){}
        public List<MetarItem> getItems(String airportCode){
            try{
                String xmlContent = XMLLoader.getContent(AMOSApiType.Metar, AMOSApiVersion.Normal, airportCode);

                return parser.parse(xmlContent);

            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    public class IWXXM20Metar{
        private IWXXM20Metar(){}
        public com.sorrymommy.amos.model.iwxxm20.MetarItem getItem(String airportCode){
            return null;
        }
    }

    public class IWXXM30Metar{
        private IWXXM30Metar(){}
        public com.sorrymommy.amos.model.iwxxm30.MetarItem getItem(String airportCode){
            return null;
        }
    }

    public class NormalTaf{
        private NormalTaf(){}
        public com.sorrymommy.amos.model.normal.TafItem getItem(String airportCode){
            return null;
        }
    }
    public class Normal{

        private Normal(){
            this.Metar = new NormalMetar();
            this.Taf = new NormalTaf();
        }
        public AMOSUtil.NormalMetar Metar;
        public AMOSUtil.NormalTaf Taf;

    }

    public class IWXXM20{
        private IWXXM20(){
            this.Metar = new IWXXM20Metar();
        }
        public AMOSUtil.IWXXM20Metar Metar;
    }

    public class IWXXM30{
        private IWXXM30(){
            this.Metar = new IWXXM30Metar();
        }
        public AMOSUtil.IWXXM30Metar Metar;
    }
    public Normal Normal = new Normal();
    public IWXXM20 IWXXM20 = new IWXXM20();
    public IWXXM30 IWXXM30 = new IWXXM30();
    public static AMOSUtil instance = new AMOSUtil();
}
