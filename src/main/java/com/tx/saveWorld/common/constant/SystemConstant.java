package com.tx.saveWorld.common.constant;

public class SystemConstant {

    public static final String TASK_NUMBER_RULE = "TN_{0}_{1}"; //任务号规则
    public static final String APPLY_NUMBER_RULE = "YJ_{0}_{1}"; //申请单编号规则
    public static final String WORKER_TIME_KEY = "biz.invoice.apply.worker.{0}";
    public static final String ET_FORMAT = "count用时:%d(ms),list用时:%d(ms)";

    /**
     * 返回Page查询时的count和list的耗时信息
     * @param st 开始count查询的时间点
     * @param et count查询返回的时间点
     * @param let 列表查询返回数据的时间
     * @return
     */
    public static String elapsedTimeTip(long st, long et, long let) {
        return String.format(ET_FORMAT,(et-st),(let-et));
    }

    /**
     * 返回Page查询时的count和list的耗时信息
     * @param st 开始count查询的时间点
     * @param et count查询返回的时间点
     * @return
     */
    public static String elapsedTimeTip(long st, long et) {
        return String.format(ET_FORMAT,(et-st),-0L);
    }
}
