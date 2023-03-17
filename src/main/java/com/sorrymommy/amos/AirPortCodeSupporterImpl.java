package com.sorrymommy.amos;

public class AirPortCodeSupporterImpl implements AirPortCodeSupporter {
    @Override
    public String[] getAirportCodes() {
        return new String[] {
                "RKSI", /* 인천공항 */
                "RKSS", /* 김포공항 */
                "RKPC", /* 제주공항 */
                "RKPK", /* 김해공항 */
                "RKNY", /* 양양공항 */
                "RKNW", /* 원주공항 */
                "RKTU", /* 청주공항 */
                "RKTN", /* 대구공항 */
                "RKTH", /* 포항공항 */
                "RKJJ", /* 광주공항 */
                "RKJB", /* 무안공항 */
                "RKJY", /* 여수공항 */
                "RKPU", /* 울산공항 */
                "RKPS", /* 사천공항 */
                "RKJK"  /* 군산공항 */ };
    }
}
