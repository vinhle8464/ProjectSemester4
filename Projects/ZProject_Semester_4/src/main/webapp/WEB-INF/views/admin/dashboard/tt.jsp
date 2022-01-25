<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:layout_admin title="Admin - Dashboard">

	<jsp:attribute name="content">
		   <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Revenue and expenditure analysis</h1>
          </div>
					<!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Dashboard v1</li>
            </ol>
          </div>
					<!-- /.col -->
        </div>
				<!-- /.row -->
      </div>
			<!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <div id="chartdiv"
			style="width: 100%; height: 400px; background-color: #FFFFFF;"></div>
     <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-6">
            	
            	 <div class="card">
              <div class="card-header">
                <h3 class="card-title">Details</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body p-0">
                <table class="table table-sm">
                  <thead>
                    <tr>
                      <th style="width: 10px">#</th>
                      <th>Indexing</th>
                      <th>Progress</th>
                      <th style="width: 40px">Label</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1.</td>
                      <td>Total income in 2022</td>
                      <td>
                        <div class="progress progress-xs">
                          <div class="progress-bar progress-bar-danger"
														style="width: 55%"></div>
                        </div>
                      </td>
                      <td><span class="badge bg-danger">55%</span></td>
                    </tr>
                    <tr>
                      <td>2.</td>
                      <td>Total income in this month</td>
                      <td>
                        <div class="progress progress-xs">
                          <div class="progress-bar bg-warning"
														style="width: 70%"></div>
                        </div>
                      </td>
                      <td><span class="badge bg-warning">70%</span></td>
                    </tr>
                    <tr>
                      <td>3.</td>
                      <td>Total expenditure in 2022</td>
                      <td>
                        <div
													class="progress progress-xs progress-striped active">
                          <div class="progress-bar bg-primary"
														style="width: 30%"></div>
                        </div>
                      </td>
                      <td><span class="badge bg-primary">30%</span></td>
                    </tr>
                    <tr>
                      <td>4.</td>
                      <td>Total expenditure in this month</td>
                      <td>
                        <div
													class="progress progress-xs progress-striped active">
                          <div class="progress-bar bg-success"
														style="width: 90%"></div>
                        </div>
                      </td>
                      <td><span class="badge bg-success">90%</span></td>
                    </tr>
                  </tbody>
                </table>
                 
              </div>
             </div>
             
              <!-- /.card-body -->
            </div>
              <div class="col-md-6">
            <div class="card">
            <div class="card-header">
                <h3 class="card-title">Expenditure in 2022</h3>
              </div>
              <div class="card-body p-0">
               <div class="card" id="chartdiv2"
									style="width: 100%; height: 400px; background-color: #FFFFFF;"></div>
              </div>
            </div>
    <!-- /.content -->
    </div>
        </div>
        <!-- /.row -->
      </div>
			<!-- /.container-fluid -->
    </section>
	</jsp:attribute>
</mt:layout_admin>

<script type="text/javascript"
	src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script type="text/javascript"
	src="https://www.amcharts.com/lib/3/serial.js"></script>
<script type="text/javascript"
	src="https://www.amcharts.com/lib/3/radar.js"></script>
<script type="text/javascript"
	src="https://www.amcharts.com/lib/3/themes/light.js"></script>


<!-- amCharts javascript code -->
<script type="text/javascript">
	AmCharts.makeChart("chartdiv", {
		"type" : "serial",
		"categoryField" : "category",
		"angle" : 30,
		"depth3D" : 30,
		"startDuration" : 1,
		"fontSize" : 9,
		"theme" : "light",
		"categoryAxis" : {
			"gridPosition" : "start"
		},
		"trendLines" : [],
		"graphs" : [ {
			"balloonText" : "[[title]] of [[category]]:[[value]]",
			"fillAlphas" : 1,
			"id" : "AmGraph-1",
			"title" : "graph 1",
			"type" : "column",
			"valueField" : "column-1"
		}],
		"guides" : [],
		"valueAxes" : [ {
			"id" : "ValueAxis-1",
			"title" : "Axis title"
		} ],
		"allLabels" : [],
		"balloon" : {},
		"legend" : {
			"enabled" : true,
			"useGraphSettings" : true
		},
		"titles" : [ {
			"id" : "Title-1",
			"size" : 15,
			"text" : "Chart Title"
		} ],
		"dataProvider" : ${categories}
	});
</script>
<script type="text/javascript">
	AmCharts.makeChart("chartdiv2", {
		"type" : "radar",
		"categoryField" : "country",
		"startDuration" : 2,
		"graphs" : [ {
			"balloonText" : "[[value]] litres of beer per year",
			"bullet" : "round",
			"id" : "AmGraph-1",
			"valueField" : "litres"
		} ],
		"guides" : [],
		"valueAxes" : [ {
			"axisTitleOffset" : 20,
			"gridType" : "circles",
			"id" : "ValueAxis-1",
			"minimum" : 0,
			"axisAlpha" : 0.15,
			"dashLength" : 3
		} ],
		"allLabels" : [],
		"balloon" : {},
		"titles" : [],
		"dataProvider" : [ {
			"country" : "January",
			"litres" : 156.9
		}, {
			"country" : "Febuary",
			"litres" : 131.1
		}, {
			"country" : "March",
			"litres" : 115.8
		}, {
			"country" : "April",
			"litres" : 109.9
		}, {
			"country" : "May",
			"litres" : 108.3
		}, {
			"country" : "June",
			"litres" : 99
		}, {
			"country" : "July",
			"litres" : null
		}, {
			"country" : "August",
			"litres" : null
		}, {
			"country" : "September",
			"litres" : null
		}, {
			"country" : "October",
			"litres" : null
		}, {
			"country" : "November",
			"litres" : null
		}, {
			"country" : "December",
			"litres" : null
		} ]
	});
</script>