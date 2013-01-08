var progressBar = {
	total : 0,
	done : 0,
	init : function() {
		var self = this;
		return (function() {
			var html = [ "<table id='progressWrapper'>" ];
			html.push("<tbody>");
			html.push("<tr>");
			html.push("<td align='center' style='vertical-align:middle;'>");
			html.push("<div>");
			html.push("<div class='logo'></div>");
			html.push("<div class='loadingbar'>");
			html.push("<div id='progressbar' class='progressbar'>");
			html.push("<div id='progressbarinner' class='progressbarinner'>");
			html.push("<div class='left'></div>");
			html.push("<div class='middle'></div>");
			html.push("<div class='right'></div>");
			html.push("</div>");
			html.push("</div>");
			html.push("<div id='progress'></div>");
			html.push("</div>");
			html.push("</div>");
			html.push("</td>");
			html.push("</tr>");
			html.push("</tbody>");
			html.push("</table>");
			var temp = document.createElement('div');
			temp.innerHTML = html.join("");
			document.getElementsByTagName('body')[0].appendChild(temp);
			// center progress bar
			var wrapper = document.getElementById('progressWrapper');
			wrapper.style.width = document.documentElement.clientWidth + 'px';
			wrapper.style.height = document.documentElement.clientHeight + 'px';

			self.wrapper = wrapper;
			self.progressBarShowerInner = document
					.getElementById('progressbarinner');
			self.totalWidth = parseInt(document.getElementById('progressbar')['offsetWidth']);
			self.progress = document.getElementById('progress');
			self.progress.innerHTML = '0%';
		})();
	},
	download : function(progress) {
		var pro, p, temp;

		this.total = progress.total;
		temp = progress.size;
		temp && (this.done += +temp);
		temp = progress.done;
		temp && (this.done = +temp);

		pro = this.done / this.total;
		p = Math.round(pro * 100);

		temp = this.progressBarShowerInner;
		temp && (temp.style.width = this.totalWidth * pro + 'px');
		temp = this.progress;
		temp && (temp.innerHTML = p + '%');

		if (p >= 100) {
			var wp = this.wrapper;
			if (wp) {
				var parent = wp.parentNode;
				if (parent && parent.nodeType == 1) {
					parent.removeChild(wp);
				}
			}
		}
	}
};