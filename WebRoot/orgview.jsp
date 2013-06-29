<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>

</head>

<body>
<!--  (Map<String, Set<Card>>)request.getAttribute("orgview"). -->
	<!-- header -->
	
	<jsp:include page="public/head.jsp"></jsp:include>
	<!-- body -->

	<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) { /* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>



				<script src="js/underscore.js"></script>
				<script src="js/bootstrap-tree.js"></script>
				<style>/* Don't mind me... */
#content {
    margin-top: 20px;
}

/* Relevant to the plugin. */
.listTree {
    margin-bottom: 18px;
}

.listTree ul {
    margin: 0;
}

.listTree li {
    list-style-type: none;
}

.listTree > ul > li {
    background-color: #eee;
    border-width: 1px 1px 0 1px;
    border-style: solid;
    border-color: #ddd;
}

.listTree > ul > li:first-child {
    border-width: 1px 1px 0 1px;
    border-top-left-radius: 3px;
    border-top-right-radius: 3px;
}

.listTree > ul > li:last-child {
    border-width: 1px;
    border-bottom-left-radius: 3px;
    border-bottom-right-radius: 3px;
}

.listTree > ul > li:last-child > ul > li:last-child {
    border-bottom-left-radius: 3px;
    border-bottom-right-radius: 3px;
}

.listTree span {
    display: inline-block;
    width: 100%;
    padding: 5px;
}

.listTree > ul > li > span {
    font-weight: bold;
}

.listTree > ul > li > ul > li {
    background-color: #fff;
    border-width: 1px 0 0 0;
    border-style: solid;
    border-color: #ddd;
    padding-left: 10px;
}

.listTree > ul > li > ul > li:first-child {
    border-width: 1px 0 0 0;
}

.listTree > ul > li > ul > li:last-child {
    border-width: 1px 0 0 0;
}

.listTree i {
    float: right;
    margin-right: 15px;
}
		</style>



	<div class="container-fluid">
		<div class="row-fluid">
		<div class="span3">
					<div class="well sidebar-nav">
						<ul class="nav nav-list">
							<li class="active">
								<a href="#">通讯录</a>
							</li>
							<c:forEach var="list" items="${circles}">
								<li>
									<a class="circle_${list.id}" href="circles?id=${list.id}"
										data-toggle="modal"
										onclick="$('#edit_circle_id_input').val(${list.id})">${list.name}
										<c:forEach var="length" items="${num}">
											<c:if test="${length.key == list.id}">
								(${length.value})
								</c:if>
										</c:forEach> </a>
								</li>
							</c:forEach>
							<!-- Button to trigger modal -->
							<li>
								<a href="#new_circle" role="button" class="btn"
									data-toggle="modal" style="width: 80px">新建群组</a>
							</li>
							<!-- Modal -->
							<div id="new_circle" class="modal hide fade" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-keyboard="false">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">
										×
									</button>
									<h3 id="myModalLabel">
										输入新建群组名称
									</h3>
								</div>
								<form action="CircleServlet" method="POST">
									<div class="modal-body">

										<p>
											输入组名
											<input type="text" name="name" />
										</p>
									</div>
									<div class="modal-footer">
										<button class="btn" data-dismiss="modal" aria-hidden="true">
											关闭
										</button>
										<button class="btn btn-primary">
											保存
										</button>
									</div>
								</form>
							</div>
						</ul>
					</div>

					<!--/.well -->
				</div>
			<!--/span-->


			<div class="span9">
				<div class="btn-group">
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"
						style="width:65px;"> <input id="selectAllCheckBox" type="checkbox"
						style="margin:3px 10px;"/> <span class="caret"></span>
						<script>
						$('#selectAllCheckBox').click(function(ev){
							$('.listTree').listTree(this.checked ? 'selectAll' : 'deselectAll');
							ev.stopPropagation();
						})
						</script>
					</a>
					<ul class="dropdown-menu">
						<li><a id="selectAll" onclick="$('.listTree').listTree('selectAll');$('#selectAllCheckBox').attr('checked', true);return false;" tabindex="-1" href="#">全选</a></li>
						<li><a id="deselectAll" onclick="$('.listTree').listTree('deselectAll');$('#selectAllCheckBox').attr('checked', false);return false;" tabindex="-1" href="#">全不选</a></li>
						<li class="divider"></li>
					</ul>
				</div>

				<div class="btn-group">
					<a href="#new_card" class="btn dropdown-toggle" style="width:65px;"
						data-toggle="modal"> <i class="icon-user"> <!-- --></i><i
						class="icon-plus"> <!--  --></i><span style="margin:3px 10px;"></span>
						<span class="caret"></span>
					</a>

					<!-- Modal -->
					<div id="new_card" class="modal hide fade" tabindex="-1"
						role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h3 id="myModalLabel">Modal header</h3>
						</div>
						<div class="modal-body">
							<input type="text" style="width:525px;height:55px;" />
						</div>
						<div class="modal-footer">
							<button class="btn" data-dismiss="modal" aria-hidden="true">
								关闭</button>
							<button class="btn btn-primary">保存</button>
						</div>
					</div>
				</div>

					<div class="btn-group">
						<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"
							style="width: 65px;"> <span style="margin: 3px 10px;">更多</span>
							<span class="caret"></span> </a>
						<ul class="dropdown-menu">
							<c:if test="${circleId!=null}">
								<li>
									<a tabindex="-1"
										href="CircleServlet?id=${circleId}&_method=delete">删除组</a>
								</li>

							</c:if>

							<li>
								<a id="deleteCard" tabindex="-1" href="#">删除联系人</a>
							</li>
							<li>
								<a tabindex="-1" href="#">合并联系人</a>
							</li>
							<li class="divider"></li>
							<!--<li>
								<a tabindex="-1" href="#">导入...</a>
							</li>-->
							<li>
								<a id="export" tabindex="-1" href="export">导出...</a>
							</li>
							<li>
								<a tabindex="-1" href="orgview">公司部门视图</a>
							</li>
						</ul>
					</div>

				<div class="btn-group" style="float:right;">
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"
						style="width:20px;height:20px;"> <i class="icon-chevron-left">
							<!--  -->
					</i>
					</a> <a class="btn dropdown-toggle" data-toggle="dropdown" href="#"
						style="width:25px;height:20px;"> <i class="icon-chevron-right">
							<!--  -->
					</i>
					</a>
				</div>

				<div class="btn-group" style="float:right;">
					<div>
						<b>zhang</b> "-" <b>test</b>
					</div>
				</div>
    <button class="btn btn-info">全部展开</button>
    <button class="btn btn-warning">全部折叠</button>
    <button class="btn btn-inverse">导出</button>

			<div id="content">
    <div class="listTree"></div>

</div>
<script>
	(function($) {
		var template = '\
        <ul>\
            \<\% _.each(context, function(parent, index) { %>\
            <li>\
                <span><input type="checkbox" \
                \<\% var ps; %>\
                \<\% if ( !_.isUndefined(ps = _.find(options.selected, function(elem) { return elem.key === this.key; }, parent)) ) { %>\
                checked="checked"\
                \<\% } %> /> \<\%= parent.key %><i class="icon-chevron-up icon-black"></i></span>\
                \<\% if (options.startCollapsed) { %>\
                <ul style="display: none;">\
                \<\% } else { %>\
                <ul>\
                \<\% } %>\
                    \<\% _.each(parent.values, function(child, index) { %>\
                    <li>\
                        <span><input class="cardentrycheckbox" type="checkbox" \
                        \<\% if ( !_.isUndefined(this) && !_.isUndefined(_.find(this.values, function(elem) { return elem.key === this.key; }, child)) ) { %>\
                        checked="checked"\
                        \<\% } %> value="\<\%= child.id %>" data-cardid="\<\%= child.id %>"/> <a href="cards?id=\<\%=child.id\%\>">\<\%= child.key %></a></span>\
                    </li>\
                    \<\% }, ps); %>\
                </ul>\
            </li>\
            \<\% }); %>\
        </ul>';

		/** Check all child checkboxes.
		 * @param jQElement The parent <li>.
		 */
		function _selectAllChildren(jQElement) {
			jQElement.find('ul > li > span > input[type="checkbox"]').each(
					function() {
						$(this).prop('checked', true);
					});
		}

		/** Uncheck all child checkboxes.
		 * @param jQElement The parent <li>.
		 */
		function _deselectAllChildren(jQElement) {
			jQElement.find('ul > li > span > input[type="checkbox"]').each(
					function() {
						$(this).prop('checked', false);
					});
		}

		/** Toggle all checkboxes.
		 * @param[in] jQElement The root <ul> of the list.
		 */
		function _toggleAllChildren(jQElement) {
			if (jQElement.children('span').children('input[type="checkbox"]')
					.prop('checked')) {
				_selectAllChildren(jQElement);
			} else {
				_deselectAllChildren(jQElement);
			}
		}

		/** Toggle the collapse icon based on the current state.
		 * @param[in] jQElement The <li> of the header to toggle.
		 */
		function _toggleIcon(jQElement) {
			// Change the icon.
			if (jQElement.children('ul').is(':visible')) {
				// The user wants to collapse the child list.
				jQElement.children('span').children('i').removeClass(
						'icon-chevron-down').addClass('icon-chevron-up');
			} else {
				// The user wants to expand the child list.
				jQElement.children('span').children('i').removeClass(
						'icon-chevron-up').addClass('icon-chevron-down');
			}
		}

		/** Make sure there isn't any bogus default selections.
		 * @param[in] selected The default selection object.
		 * @return The filtered selection object.
		 */
		function _validateDefaultSelectionValues(selected) {
			return _.filter(selected,
					function(elem) {
						return (!_.isEmpty(elem.values) && !_
								.isUndefined(elem.values));
					});
		}

		/** If a parent has at least one child node selected, check the parent.
		 *  Conversely, if a parent has no child nodes selected, uncheck the parent.
		 * @param[in] jQElement The parent <li>.
		 */
		function _handleChildParentRelationship(jQElement) {
			// If the selected node is a child:
			if (_.isEmpty(_.toArray(jQElement.children('ul')))) {
				var childrenStatuses = _.uniq(_.map(jQElement.parent().find(
						'input[type="checkbox"]'), function(elem) {
					return $(elem).prop('checked');
				}));

				// Check to see if any children are checked.
				if (_.indexOf(childrenStatuses, true) !== -1) {
					// Check the parent node.
					jQElement.parent().parent().children('span').children(
							'input[type="checkbox"]').prop('checked', true);
				} else {
					// Uncheck the parent node.
					jQElement.parent().parent().children('span').children(
							'input[type="checkbox"]').prop('checked', false);
				}
			}
		}

		/** Updates the internal object of selected nodes.
		 */
		function _updateSelectedObject() {
			var data = $('.listTree').data('listTree');

			// Filter the context to the selected parents.
			var selected = _.filter($.extend(true, {}, data.context), function(
					parent) {
				return $(
						'.listTree > ul > li > span > input[value="'
								+ parent.key + '"]').prop('checked')
			});

			// For each parent in the working context...
			_.each(selected, function(parent) {

				// Filter the children to the selected children.
				parent.values = _.filter(parent.values, function(child) {
					return $(
							'.listTree > ul > li > ul > li > span > input[value="'
									+ child.key + '"]').prop('checked');
				});
			});

			// Update the plugin's selected object.
			$('.listTree').data('listTree', {
				"target" : data.target,
				"context" : data.context,
				"options" : data.options,
				"selected" : selected
			});
		}

		var methods = {
			init : function(context, options) {
				// Default options
				var defaults = {
					"startCollapsed" : false,
					"selected" : context
				};
				options = $.extend(defaults, options);

				// Validate the user entered default selections.
				options.selected = _validateDefaultSelectionValues(options.selected);

				return this.each(function() {
					var $this = $(this), data = $this.data('listTree');

					// If the plugin hasn't been initialized yet...
					if (!data) {

						$(this).data('listTree', {
							"target" : $this,
							"context" : context,
							"options" : options,
							"selected" : options.selected
						});

						// Register checkbox handlers.
						$(document).on('change',
								'.listTree input[type="checkbox"]',
								function(e) {
									var node = $(e.target).parent().parent();

									// Toggle all children.
									_toggleAllChildren(node);

									// Handle parent checkbox if all children are (un)checked.
									_handleChildParentRelationship(node);

									// Filter context to selection and store in data.selected.
									_updateSelectedObject(node);
								})

						// Register collapse handlers on parents.
						.on('click', '.listTree > ul > li > span', function(e) {
							var node = $(e.target).parent();

							// Change the icon.
							_toggleIcon(node);

							// Toggle the child list.
							node.children('ul').slideToggle('fast');

							e.stopImmediatePropagation();
						});

						// Generate the list tree.
						$this.html(_.template(template, {
							"context" : context,
							"options" : options
						}));
					}
				});
			},
			destroy : function() {
				return this.each(function() {

					var $this = $(this), data = $this.data('listTree');

					$(window).unbind('.listTree');
					$this.removeData('listTree');
				});
			},
			selectAll : function() {
				// For each listTree...
				return this.each(function() {
					// Select each parent checkbox.
					_selectAllChildren($(this));

					// For each listTree parent...
					$(this).children('ul > li:first-child').each(function() {
						// Select each child checkbox.
						_selectAllChildren($(this));
					});

					_updateSelectedObject($(this));
				});
			},
			deselectAll : function() {
				// For each listTree...
				return this.each(function() {
					// Deselect each parent checkbox.
					_deselectAllChildren($(this));

					// For each listTree parent...
					$(this).children('ul > li:first-child').each(function() {
						// Deselect each child checkbox.
						_deselectAllChildren($(this));
					});

					_updateSelectedObject($(this));
				});
			},
			expandAll : function() {
				// For each listTree...
				return this.each(function() {
					var node = $(this).children('ul').children('li');

					// Change the icon.
					_toggleIcon(node);

					// Show the child list.
					node.children('ul').slideDown('fast');
				});
			},
			collapseAll : function() {
				// For each listTree...
				return this.each(function() {
					var node = $(this).children('ul').children('li');

					// Change the icon.
					_toggleIcon(node);

					// Hide the child list.
					node.children('ul').slideUp('fast');
				});
			},
			update : function(context, options) {
				// Default options
				var defaults = {
					"startCollapsed" : false,
					"selected" : context
				};
				options = $.extend(defaults, options);

				// Validate the user entered default selections.
				options.selected = _validateDefaultSelectionValues(options.selected);

				return this.each(function() {
					var $this = $(this), data = $this.data('listTree');

					// Ensure the plugin has been initialized...
					if (data) {
						// Update the context.
						$(this).data('listTree', {
							"target" : $this,
							"context" : context,
							"options" : options,
							"selected" : options.selected
						});

						// Generate the list tree.
						$this.html(_.template(template, {
							"context" : context,
							"options" : options
						}));
					}
				});
			}
		};

		$.fn.listTree = function(method) {

			if (methods[method]) {
				return methods[method].apply(this, Array.prototype.slice.call(
						arguments, 1));
			} else if (typeof method === 'object' || !method) {
				return methods.init.apply(this, arguments);
			} else {
				$.error('Method ' + method
						+ ' does not exist on jQuery.listTree');
			}

		};
	})(jQuery);

	/* Create our data objects.
	 * Formatted like d3.js's nest() function.
	 */
	 
	var data = ${orgviewjson};


	$(document).on('click', '.btn-success', function(e) {
		$('.listTree').listTree('selectAll');
	}).on('click', '.btn-danger', function(e) {
		$('.listTree').listTree('deselectAll');
	}).on('click', '.btn-info', function(e) {
		$('.listTree').listTree('expandAll');
	}).on('click', '.btn-warning', function(e) {
		$('.listTree').listTree('collapseAll');
	}).on(
			'click',
			'.btn-primary',
			function(e) {
				$('#selectionJson')
						.text(
								JSON
										.stringify($('.listTree').data(
												'listTree').selected));
			});

	$('.listTree').listTree(data, {
		"startCollapsed" : true,
		"selected" : []
	});
</script>

<script>
$('#deleteCard').click(function() {
	var checkboxes = $('.cardentrycheckbox')
	var result = new Array();
	for (i = 0; i < checkboxes.length; i++) {
		if (checkboxes[i].checked) {
			result.push($(checkboxes[i]).attr('data-cardid'))
		}
	}
	location.href = "CardServlet?delete=delete&id=" + result.join(',')
	return false;
})

$('#export').click(function() {
	var checkboxes = $('.cardentrycheckbox')
	var result = new Array();
	for (i = 0; i < checkboxes.length; i++) {
		if (checkboxes[i].checked) {
			result.push($(checkboxes[i]).attr('data-cardid'))
		}
	}
	location.href = "export?id=" + result.join(',')
	return false;
})

$('#merge').click(function() {
	var checkboxes = $('.cardentrycheckbox')
	var result = new Array();
	for (i = 0; i < checkboxes.length; i++) {
		if (checkboxes[i].checked) {
			result.push($(checkboxes[i]).attr('data-cardid'))
		}
	}
	location.href = "merge?id=" + result.join(',')
	return false;
})
</script>			
			
			</div>
		</div>
	</div>
  </body>
</html>
