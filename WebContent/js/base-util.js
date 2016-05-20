/**
 * @comment item 为匹配的标签的jquery对象，t表示剩余时间 实现功能为10秒内，渐渐消失
 */
function tsotsi(item, t) {
	if (t >= 0) {
		item.css({
			filter : 'alpha(opacity=' + 10 * t + ')', /* ie 有效 */
			'-moz-opacity' : 0.1 * t, /* Firefox 有效 */
			'opacity' : 0.1 * t
		/* 通用，其他浏览器 有效 */
		});
		setTimeout(tsotsi, 500, item, t - 0.5);
	}
}