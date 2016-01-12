<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ attribute name="title" required="true" %>
<html>
    <head>
        <title>${title}</title>
        <meta charset="utf-8">
        <meta name="_csrf" content="${_csrf.token}"/>
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
        <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="/js/datepicker/jquery.datetimepicker.css" />

        <script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="/js/form-to-json-object.js"></script>
        <script type="text/javascript" src="/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/js/mask-money.js"></script>
        <script type="text/javascript" src="/js/datepicker/jquery.datetimepicker.js"></script>


        <script>
            $(document).ready(function(){
                $('.datetime-calendar').datetimepicker({
                    lang:'pt-BR',
                    closeOnWithoutClick:true,
                    i18n:{
                        de:{
                            months:[
                                'Janeiro','Fevereiro','Março','Abril',
                                'Maio','Junho','Julho','Agosto',
                                'Septembro','Outubro','Novembro','Dezembro',
                            ],
                            dayOfWeek:[
                                "Seg.", "Ter.", "Qua.", "Qui.",
                                "Sex.", "Sab.", "Dom.",
                            ]
                        }
                    },
                    timepicker:true,
                    format:'d/m/Y H:i'
                });
            })
        </script>

        <script>
            $(document).ready(function(){
                $("input.money").maskMoney({showSymbol:false, symbol:"R$", decimal:",", thousands:"."});
            });
        </script>

        <script>
            $(function () {
                $('[data-toggle="tooltip"]').tooltip()
            })
        </script>

    </head>

    <body>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Financeiro</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Caixa <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${spring:mvcUrl("CDC#saveForm").build()}"><span class="glyphicon glyphicon-plus-sign"></span> Novo Caixa</a></li>
                            <li><a href="${spring:mvcUrl("CDC#list").build()}"><span class="glyphicon glyphicon-list"></span> Listar Caixas</a></li>
                        </ul>
                    </li>
                </ul>

                <p class="navbar-text navbar-right hidden-sm hidden-xs">Desenvolvido por <strong>Felipe Romani</strong> <span class="glyphicon glyphicon-hand-right"></span> <small> Spring Boot | Spring Security | Spring Web MVC | JPA | HSQL | Spring Data JPA | JSP | Bean Validation</small></p>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

    <div class="col-md-12">
        <jsp:doBody />
    </div>

    </body>

<script>
    $(function () {
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        $(document).ajaxSend(function(e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    });
</script>

</html>