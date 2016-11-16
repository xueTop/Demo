package comm.mobile.demo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/15.
 */
public class LiveEntity {


    /**
     * ret : 0000
     * result : {"recommandRadioList":[{"picPath":"http://fdfs.xmcdn.com/group9/M04/E5/5E/wKgDZlaXaaCxVIwIAACvfe9Doz4777_mobile_large.jpg","radioId":1631,"radioPlayCount":52901,"radioPlayUrl":{"radio_24_aac":"http://live.xmcdn.com/live/1733/24.m3u8","radio_24_ts":"http://live.xmcdn.com/live/1733/24.m3u8?transcode=ts","radio_64_aac":"http://live.xmcdn.com/live/1733/64.m3u8","radio_64_ts":"http://live.xmcdn.com/live/1733/64.m3u8?transcode=ts"},"rname":"上海新闻广播"},{"picPath":"http://fdfs.xmcdn.com/group6/M0B/88/AE/wKgDg1T_onvAdZaNAAAR20zHDOg703_mobile_large.jpg","radioId":752,"radioPlayCount":231093,"radioPlayUrl":{"radio_24_aac":"http://live.xmcdn.com/live/752/24.m3u8","radio_24_ts":"http://live.xmcdn.com/live/752/24.m3u8?transcode=ts","radio_64_aac":"http://live.xmcdn.com/live/752/64.m3u8","radio_64_ts":"http://live.xmcdn.com/live/752/64.m3u8?transcode=ts"},"rname":"四川交通广播"},{"picPath":"http://fdfs.xmcdn.com/group6/M00/88/A2/wKgDg1T_od6yORyJAAARDfnnUq0858_mobile_large.jpg","radioId":886,"radioPlayCount":558703,"radioPlayUrl":{"radio_24_aac":"http://live.xmcdn.com/live/886/24.m3u8","radio_24_ts":"http://live.xmcdn.com/live/886/24.m3u8?transcode=ts","radio_64_aac":"http://live.xmcdn.com/live/886/64.m3u8","radio_64_ts":"http://live.xmcdn.com/live/886/64.m3u8?transcode=ts"},"rname":"山西音乐广播"}],"topRadioList":[{"programId":45787,"programName":"小喇叭","programScheduleId":176453,"radioCoverLarge":"http://fdfs.xmcdn.com/group6/M08/84/D2/wKgDhFT_oxGzpBYYAABn8GON2wI270_mobile_large.jpg","radioCoverSmall":"http://fdfs.xmcdn.com/group6/M08/84/D2/wKgDhFT_oxGzpBYYAABn8GON2wI270_mobile_small.jpg","radioId":1065,"radioPlayCount":31544490,"radioPlayUrl":{"radio_24_aac":"http://live.xmcdn.com/live/1065/24.m3u8","radio_24_ts":"http://live.xmcdn.com/live/1065/24.m3u8?transcode=ts","radio_64_aac":"http://live.xmcdn.com/live/1065/64.m3u8","radio_64_ts":"http://live.xmcdn.com/live/1065/64.m3u8?transcode=ts"},"rname":"CNR中国之声"},{"programId":140221,"programName":"东方时空","programScheduleId":5506,"radioCoverLarge":"http://fdfs.xmcdn.com/group6/M01/AC/E1/wKgDg1UKkJPSIj2SAAAQ4E4jm4k101_mobile_large.jpg","radioCoverSmall":"http://fdfs.xmcdn.com/group6/M01/AC/E1/wKgDg1UKkJPSIj2SAAAQ4E4jm4k101_mobile_small.jpg","radioId":1067,"radioPlayCount":5374064,"radioPlayUrl":{"radio_24_aac":"http://live.xmcdn.com/live/1067/24.m3u8","radio_24_ts":"http://live.xmcdn.com/live/1067/24.m3u8?transcode=ts","radio_64_aac":"http://live.xmcdn.com/live/1067/64.m3u8","radio_64_ts":"http://live.xmcdn.com/live/1067/64.m3u8?transcode=ts"},"rname":"CCTV13新闻频道"},{"programId":45829,"programName":"中国TOP排行榜","programScheduleId":220,"radioCoverLarge":"http://fdfs.xmcdn.com/group6/M0A/AC/B3/wKgDg1UKhxSiBQSKAAD06SSV5o4807_mobile_large.jpg","radioCoverSmall":"http://fdfs.xmcdn.com/group6/M0A/AC/B3/wKgDg1UKhxSiBQSKAAD06SSV5o4807_mobile_small.jpg","radioId":12,"radioPlayCount":12390555,"radioPlayUrl":{"radio_24_aac":"http://live.xmcdn.com/live/12/24.m3u8","radio_24_ts":"http://live.xmcdn.com/live/12/24.m3u8?transcode=ts","radio_64_aac":"http://live.xmcdn.com/live/12/64.m3u8","radio_64_ts":"http://live.xmcdn.com/live/12/64.m3u8?transcode=ts"},"rname":"CNR音乐之声"}]}
     * msg : 成功
     */

    private String ret;
    private ResultBean result;
    private String msg;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class ResultBean {
        /**
         * picPath : http://fdfs.xmcdn.com/group9/M04/E5/5E/wKgDZlaXaaCxVIwIAACvfe9Doz4777_mobile_large.jpg
         * radioId : 1631
         * radioPlayCount : 52901
         * radioPlayUrl : {"radio_24_aac":"http://live.xmcdn.com/live/1733/24.m3u8","radio_24_ts":"http://live.xmcdn.com/live/1733/24.m3u8?transcode=ts","radio_64_aac":"http://live.xmcdn.com/live/1733/64.m3u8","radio_64_ts":"http://live.xmcdn.com/live/1733/64.m3u8?transcode=ts"}
         * rname : 上海新闻广播
         */

        private List<RecommandRadioListBean> recommandRadioList;
        /**
         * programId : 45787
         * programName : 小喇叭
         * programScheduleId : 176453
         * radioCoverLarge : http://fdfs.xmcdn.com/group6/M08/84/D2/wKgDhFT_oxGzpBYYAABn8GON2wI270_mobile_large.jpg
         * radioCoverSmall : http://fdfs.xmcdn.com/group6/M08/84/D2/wKgDhFT_oxGzpBYYAABn8GON2wI270_mobile_small.jpg
         * radioId : 1065
         * radioPlayCount : 31544490
         * radioPlayUrl : {"radio_24_aac":"http://live.xmcdn.com/live/1065/24.m3u8","radio_24_ts":"http://live.xmcdn.com/live/1065/24.m3u8?transcode=ts","radio_64_aac":"http://live.xmcdn.com/live/1065/64.m3u8","radio_64_ts":"http://live.xmcdn.com/live/1065/64.m3u8?transcode=ts"}
         * rname : CNR中国之声
         */

        private List<TopRadioListBean> topRadioList;

        public List<RecommandRadioListBean> getRecommandRadioList() {
            return recommandRadioList;
        }

        public void setRecommandRadioList(List<RecommandRadioListBean> recommandRadioList) {
            this.recommandRadioList = recommandRadioList;
        }

        public List<TopRadioListBean> getTopRadioList() {
            return topRadioList;
        }

        public void setTopRadioList(List<TopRadioListBean> topRadioList) {
            this.topRadioList = topRadioList;
        }

        public static class RecommandRadioListBean {
            private String picPath;
            private int radioId;
            private int radioPlayCount;
            /**
             * radio_24_aac : http://live.xmcdn.com/live/1733/24.m3u8
             * radio_24_ts : http://live.xmcdn.com/live/1733/24.m3u8?transcode=ts
             * radio_64_aac : http://live.xmcdn.com/live/1733/64.m3u8
             * radio_64_ts : http://live.xmcdn.com/live/1733/64.m3u8?transcode=ts
             */

            private RadioPlayUrlBean radioPlayUrl;
            private String rname;

            public String getPicPath() {
                return picPath;
            }

            public void setPicPath(String picPath) {
                this.picPath = picPath;
            }

            public int getRadioId() {
                return radioId;
            }

            public void setRadioId(int radioId) {
                this.radioId = radioId;
            }

            public int getRadioPlayCount() {
                return radioPlayCount;
            }

            public void setRadioPlayCount(int radioPlayCount) {
                this.radioPlayCount = radioPlayCount;
            }

            public RadioPlayUrlBean getRadioPlayUrl() {
                return radioPlayUrl;
            }

            public void setRadioPlayUrl(RadioPlayUrlBean radioPlayUrl) {
                this.radioPlayUrl = radioPlayUrl;
            }

            public String getRname() {
                return rname;
            }

            public void setRname(String rname) {
                this.rname = rname;
            }

            public static class RadioPlayUrlBean {
                private String radio_24_aac;
                private String radio_24_ts;
                private String radio_64_aac;
                private String radio_64_ts;

                public String getRadio_24_aac() {
                    return radio_24_aac;
                }

                public void setRadio_24_aac(String radio_24_aac) {
                    this.radio_24_aac = radio_24_aac;
                }

                public String getRadio_24_ts() {
                    return radio_24_ts;
                }

                public void setRadio_24_ts(String radio_24_ts) {
                    this.radio_24_ts = radio_24_ts;
                }

                public String getRadio_64_aac() {
                    return radio_64_aac;
                }

                public void setRadio_64_aac(String radio_64_aac) {
                    this.radio_64_aac = radio_64_aac;
                }

                public String getRadio_64_ts() {
                    return radio_64_ts;
                }

                public void setRadio_64_ts(String radio_64_ts) {
                    this.radio_64_ts = radio_64_ts;
                }
            }
        }

        public static class TopRadioListBean {
            private int programId;
            private String programName;
            private int programScheduleId;
            private String radioCoverLarge;
            private String radioCoverSmall;
            private int radioId;
            private int radioPlayCount;
            /**
             * radio_24_aac : http://live.xmcdn.com/live/1065/24.m3u8
             * radio_24_ts : http://live.xmcdn.com/live/1065/24.m3u8?transcode=ts
             * radio_64_aac : http://live.xmcdn.com/live/1065/64.m3u8
             * radio_64_ts : http://live.xmcdn.com/live/1065/64.m3u8?transcode=ts
             */

            private RadioPlayUrlBean radioPlayUrl;
            private String rname;

            public int getProgramId() {
                return programId;
            }

            public void setProgramId(int programId) {
                this.programId = programId;
            }

            public String getProgramName() {
                return programName;
            }

            public void setProgramName(String programName) {
                this.programName = programName;
            }

            public int getProgramScheduleId() {
                return programScheduleId;
            }

            public void setProgramScheduleId(int programScheduleId) {
                this.programScheduleId = programScheduleId;
            }

            public String getRadioCoverLarge() {
                return radioCoverLarge;
            }

            public void setRadioCoverLarge(String radioCoverLarge) {
                this.radioCoverLarge = radioCoverLarge;
            }

            public String getRadioCoverSmall() {
                return radioCoverSmall;
            }

            public void setRadioCoverSmall(String radioCoverSmall) {
                this.radioCoverSmall = radioCoverSmall;
            }

            public int getRadioId() {
                return radioId;
            }

            public void setRadioId(int radioId) {
                this.radioId = radioId;
            }

            public int getRadioPlayCount() {
                return radioPlayCount;
            }

            public void setRadioPlayCount(int radioPlayCount) {
                this.radioPlayCount = radioPlayCount;
            }

            public RadioPlayUrlBean getRadioPlayUrl() {
                return radioPlayUrl;
            }

            public void setRadioPlayUrl(RadioPlayUrlBean radioPlayUrl) {
                this.radioPlayUrl = radioPlayUrl;
            }

            public String getRname() {
                return rname;
            }

            public void setRname(String rname) {
                this.rname = rname;
            }

            public static class RadioPlayUrlBean {
                private String radio_24_aac;
                private String radio_24_ts;
                private String radio_64_aac;
                private String radio_64_ts;

                public String getRadio_24_aac() {
                    return radio_24_aac;
                }

                public void setRadio_24_aac(String radio_24_aac) {
                    this.radio_24_aac = radio_24_aac;
                }

                public String getRadio_24_ts() {
                    return radio_24_ts;
                }

                public void setRadio_24_ts(String radio_24_ts) {
                    this.radio_24_ts = radio_24_ts;
                }

                public String getRadio_64_aac() {
                    return radio_64_aac;
                }

                public void setRadio_64_aac(String radio_64_aac) {
                    this.radio_64_aac = radio_64_aac;
                }

                public String getRadio_64_ts() {
                    return radio_64_ts;
                }

                public void setRadio_64_ts(String radio_64_ts) {
                    this.radio_64_ts = radio_64_ts;
                }
            }
        }
    }
}
