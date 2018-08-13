<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <form id="editForm" class="form-horizontal" role="form" action="editFilm.do" method="post">
        <div class="form-group">
            <div class="col-xs-4">
                <input name="filmId" type="hidden" class="form-control" value="<%=request.getParameter("filmId")%>">
            </div>
            <div class="col-xs-6"></div>
        </div>
        <div class="form-group">
            <label class="col-xs-2 control-label">电影标题</label>
            <div class="col-xs-4">
                <input name="title" type="text" class="form-control">
            </div>
            <div class="col-xs-6"></div>
        </div>
        <div class="form-group">
            <label class="col-xs-2 control-label">电影描述</label>
            <div class="col-xs-4">
                <input name="description" type="text" class="form-control">
            </div>
            <div class="col-xs-6"></div>
        </div>
        <div class="form-group">
            <label class="col-xs-2 control-label">语言</label>
            <div class="col-xs-4">
                <select class="selectpicker show-tick" data-live-search="true" data-size="5" name="languageId">
                    <option value="1">English</option>
                    <option value="2">Italian</option>
                    <option value="3">Japanese</option>
                    <option value="4">Mandarin</option>
                    <option value="5">French</option>
                    <option value="6">German</option>
                </select>
            </div>
            <div class="col-xs-6"></div>
        </div>
    </form>
</div>
