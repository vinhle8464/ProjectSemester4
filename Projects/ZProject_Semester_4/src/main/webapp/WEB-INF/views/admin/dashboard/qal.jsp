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
            <h1 class="m-0">New member analysis</h1>
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
   
     <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-6">
            <div class="card">
            <div class="card-header">
                <h3 class="card-title">New member in 2022</h3>
              </div>
              <div class="card-body p-0">
                <div id="chartdiv"
							style="width: 100%; height: 400px; background-color: #FFFFFF;"></div>
              </div>
            </div>
    <!-- /.content -->
    </div>
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
                      <td>Total New User in 2022</td>
                      <td>
                        <div class="progress progress-xs">
                          <div class="progress-bar progress-bar-danger"
														style="width: 55%"></div>
                        </div>
                      </td>
                      <td><span class="badge bg-danger">55%</span></td>
                    </tr>
                    <tr>
                      <td></td>
                      <td>Faculty</td>
                      <td>
                        <div class="progress progress-xs">
                          <div class="progress-bar bg-warning"
														style="width: 70%"></div>
                        </div>
                      </td>
                      <td><span class="badge bg-warning">70%</span></td>
                    </tr>
                    <tr>
                      <td></td>
                      <td>User</td>
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
                      <td>2.</td>
                      <td>Total User</td>
                      <td>
                        <div
													class="progress progress-xs progress-striped active">
                          <div class="progress-bar bg-success"
														style="width: 90%"></div>
                        </div>
                      </td>
                      <td><span class="badge bg-success">90%</span></td>
                    </tr>
                    <tr>
                      <td></td>
                      <td>Faculty</td>
                      <td>
                        <div
													class="progress progress-xs progress-striped active">
                          <div class="progress-bar bg-success"
														style="width: 90%"></div>
                        </div>
                      </td>
                      <td><span class="badge bg-success">90%</span></td>
                    </tr>
                    <tr>
                      <td></td>
                      <td>User</td>
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



<!-- amCharts javascript code -->
	<script type="text/javascript">
			AmCharts.makeChart("chartdiv",
				{
					"type": "radar",
					"categoryField": "country",
					"startDuration": 2,
					"graphs": [
						{
							"balloonText": "[[value]] litres of beer per year",
							"bullet": "round",
							"id": "AmGraph-1",
							"valueField": "litres"
						}
					],
					"guides": [],
					"valueAxes": [
						{
							"axisTitleOffset": 20,
							"id": "ValueAxis-1",
							"minimum": 0,
							"axisAlpha": 0.15,
							"dashLength": 3
						}
					],
					"allLabels": [],
					"balloon": {},
					"titles": [],
					"dataProvider": [
						{
							"country": "Czech Republic",
							"litres": 156.9
						},
						{
							"country": "Ireland",
							"litres": 131.1
						},
						{
							"country": "Germany",
							"litres": 115.8
						},
						{
							"country": "Australia",
							"litres": 109.9
						},
						{
							"country": "Austria",
							"litres": 108.3
						},
						{
							"country": "UK",
							"litres": 99
						}
					]
				}
			);
		</script>
