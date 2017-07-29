(function(window) {
	var lcf = (window.lcf) ? (window.lcf) : {};
	lcf.common = {
		redisplySelect: function($targetSelect, targetValue) {
			if (null == targetValue) {
				targetValue = $targetSelect.attr('sc');
			}
			$targetSelect.children().each(function() {
				var opt = $(this);
				if (opt.attr("value") == targetValue) {
					opt.attr("selected", "selected");
					return false;
				}
			});
		},
		highlight4Table: function($table, highlightClassName) {
			if (null == highlightClassName) {
				highlightClassName = "highlight";
			}
			$table.find("tr").each(function(i) {
				if (i > 0) {
					$(this).mouseover(function() {
						$(this).addClass(highlightClassName);
					}).mouseout(function() {
						$(this).removeClass(highlightClassName);
					});
				}
			});
		},
		/**
		 * @param syncAttrName
		 *            can bind mult checkbox for control
		 */
		bindCheckboxAllSelect: function($checkboxArray, syncAttrName) {
			if (null == syncAttrName) {
				syncAttrName = "sync";
			}
			$checkboxArray.each(function() {
				var $that = $(this);
				if ($that.attr(syncAttrName)) {
					$that.click(function() {
						var checked = $that[0].checked;
						$checkboxArray.each(function() {
							this.checked = checked;
						});
					});
				}
			});
		}
	};

	lcf.page = {
		frmChangePage: null,
		hdnCurrentPage: null,
		hdnPageSize: null,
		hdnSkipPage: null,
		changePage: function(hopePageNumber, hopePageSize) {
			this.init();
			if (null != hopePageSize) {
				hopePageSize = parseInt(hopePageSize);
				if (hopePageSize < 1 || hopePageSize > 100) {
				} else {
					this.hdnPageSize.val(hopePageSize);
				}
			}
			this.hdnCurrentPage.val(hopePageNumber);
			this.frmChangePage.submit();
		},
		changePartPage: function(hopePageNumber, hopePageSize) {
			this.init();
			if (null != hopePageSize) {
				hopePageSize = parseInt(hopePageSize);
				if (hopePageSize < 1 || hopePageSize > 100) {
				} else {
					this.hdnPageSize.val(hopePageSize);
				}
			}
			this.hdnCurrentPage.val(hopePageNumber);
			this.frmChangePage.submit();
		},
		skipPage: function() {
			this.init();
			this.hdnCurrentPage.val(eval(this.hdnSkipPage.val()));
			this.frmChangePage.submit();
		},
		reflash: function() {
			this.init();
			this.frmChangePage.submit();
		},
		init: function() {
			this.frmChangePage = $("#frmChangePage");
			this.hdnCurrentPage = $("#hdnCurrentPage");
			this.hdnSkipPage = $("#hdnSkipPage");
			this.hdnPageSize = $("#hdnPageSize");
		}
	};

	window.lcf = lcf;
})(window);

Date.prototype.toDate = function() {
	var m = (this.getMonth() + 1);
	var d = this.getDate();
	return this.getFullYear() + '-' + (m < 10 ? '0' + m : m) + '-' + (d < 10 ? '0' + d : d);
}
//document.backup_domain = document.domain;
//document.domain="duowan.com";