
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
</head>
<body>
<center>To khai y te</center>
<form:form action="/send_declaration" modelAttribute="information">
    <div class="container">
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="name">Name</label>
                <form:input path="name" class="form-control" id="name"></form:input>
                <p style="color: red">${nameErr}</p>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-4 mb-3">
                <label for="birthday">birthday</label>
                <form:input type="date" path="birthday" class="form-control" id="birthday"></form:input>
            </div>
            <div class="col-md-4 mb-3">
                <label for="gender">gender</label>
                <form:select path="gender" class="form-control" id="gender">
                    <form:options items="${gender}"></form:options>
                </form:select>
            </div>
            <div class="col-md-4 mb-3">
                <label for="national">country</label>
                <form:select type="text" path="national" class="form-control" id="national">
                    <form:options items="${countries}"></form:options>
                </form:select>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <label for="idCard">idCard</label>
                <form:input path="idCard" class="form-control" id="idCard"></form:input>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <label for="vehicleMove">Thong tin di lai</label>
                <table>
                    <tr>
                        <td>
                            <form:radiobuttons path="vehicleMove" id="vehicleMove"
                                               items="${transferBy}"></form:radiobuttons>
                        </td>
                    </tr>
                </table>
            </div>
        </div>

        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label for="vehicleNumber">vehicleNumber</label>
                <form:input type="text" path="vehicleNumber" class="form-control" id="vehicleNumber"></form:input>
            </div>
            <div class="col-md-6 mb-3">
                <label for="chairNumber">seatNumber</label>
                <form:input type="text" path="chairNumber" class="form-control" id="chairNumber"></form:input>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label for="startDay">departAt</label>
                <form:input type="date" path="startDay" class="form-control" id="startDay"></form:input>
            </div>
            <div class="col-md-6 mb-3">
                <label for="endDay">arriveBy</label>
                <form:input type="date" path="endDay" class="form-control" id="endDay"></form:input>
            </div>
        </div>
        <div class="form-row">
            <div class="col mb-3">
                <label for="movingInformation">whereToGoIn14Days</label>
                <form:input path="movingInformation" class="form-control" id="movingInformation"></form:input>
            </div>
        </div>
        <div class="form-row">Dia chi lien lac</div>
        <div class="form-row">
            <div class="col-md-4 mb-3">
                <label for="cityName">province</label>
                <form:select type="text" path="cityName" class="form-control" id="cityName">
                    <form:options items="${province}"></form:options>
                </form:select>
            </div>
            <div class="col-md-4 mb-3">
                <label for="districtName">district</label>
                <form:select type="text" path="districtName" class="form-control" id="districtName">
                    <form:options items="${district}"></form:options>
                </form:select>
            </div>
            <div class="col-md-4 mb-3">
                <label for="wardsName">ward</label>
                <form:select type="text" path="wardsName" class="form-control" id="wardsName">
                    <form:options items="${ward}"></form:options>
                </form:select>
            </div>
        </div>

        <div class="form-row">Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện các dấu hiệu</div>

        <div class="container">
            <div class="row">
                <div class="col-lg-6  text-start">
                    <label for="phone">phone</label>
                    <form:input type="text" path="phone" class="form-control" id="phone"></form:input>
                </div>
                <div class="col-lg-6  text-start">
                    <label for="email">email</label>
                    <form:input type="text" path="email" class="form-control" id="email"></form:input>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-lg-6  text-start">
                    <div class="row">
                        <div class="col-lg-8">
                            <p>Triệu chứng</p>
                        </div>
                        <div class="col-lg-2">
                            <p>co</p>
                        </div>
                        <div class="col-lg-2">
                            <p>Khong</p>
                        </div>
                    </div>
                    <hr>

                    <div class="row">
                        <div class="col-lg-8">
                            <span>Sốt</span>
                        </div>
                        <div class="col-lg-2">
                            <span> <form:radiobutton path="fever"></form:radiobutton></span>
                        </div>
                        <div class="col-lg-2">
                            <span><form:radiobutton path="fever"></form:radiobutton></span>
                        </div>
                    </div>
                    <hr>

                    <div class="row">
                        <div class="col-lg-8">
                            <span>Ho</span>
                        </div>
                        <div class="col-lg-2">
                            <span> <form:radiobutton path="cough"></form:radiobutton></span>
                        </div>
                        <div class="col-lg-2">
                            <span><form:radiobutton path="cough"></form:radiobutton></span>
                        </div>
                    </div>
                    <hr>

                    <div class="row">
                        <div class="col-lg-8">
                            <span>Khó Thở</span>
                        </div>
                        <div class="col-lg-2">
                            <span> <form:radiobutton path="difficultyOfBreathing"></form:radiobutton></span>
                        </div>
                        <div class="col-lg-2">
                            <span><form:radiobutton path="difficultyOfBreathing"></form:radiobutton></span>
                        </div>
                    </div>
                    <hr>

                    <div class="row">
                        <div class="col-lg-8">
                            <span>Đau Họng</span>
                        </div>
                        <div class="col-lg-2">
                            <span> <form:radiobutton path="soreThroat"></form:radiobutton></span>
                        </div>
                        <div class="col-lg-2">
                            <span><form:radiobutton path="soreThroat"></form:radiobutton></span>
                        </div>
                    </div>
                    <hr>
                </div>


                <div class="col-lg-6  text-start">

                    <div class="row">
                        <div class="col-lg-8">
                            <p>Triệu chứng</p>
                        </div>
                        <div class="col-lg-2">
                            <p>co</p>
                        </div>
                        <div class="col-lg-2">
                            <p>Khong</p>
                        </div>
                    </div>
                    <hr>

                    <div class="row">
                        <div class="col-lg-8">
                            <span>Nôn/buồn nôn</span>
                        </div>
                        <div class="col-lg-2">
                            <span> <form:radiobutton path="vomiting"></form:radiobutton></span>
                        </div>
                        <div class="col-lg-2">
                            <span><form:radiobutton path="vomiting"></form:radiobutton></span>
                        </div>
                    </div>
                    <hr>

                    <div class="row">
                        <div class="col-lg-8">
                            <span>Tiêu chảy</span>
                        </div>
                        <div class="col-lg-2">
                            <span> <form:radiobutton path="diarrhea"></form:radiobutton></span>
                        </div>
                        <div class="col-lg-2">
                            <span><form:radiobutton path="diarrhea"></form:radiobutton></span>
                        </div>
                    </div>
                    <hr>


                    <div class="row">
                        <div class="col-lg-8">
                            <span>Xuất Huyết Ngoài Da</span>
                        </div>
                        <div class="col-lg-2">
                            <span> <form:radiobutton path="skinHemorrhage"></form:radiobutton></span>
                        </div>
                        <div class="col-lg-2">
                            <span><form:radiobutton path="skinHemorrhage"></form:radiobutton></span>
                        </div>
                    </div>
                    <hr>

                    <div class="row">
                        <div class="col-lg-8">
                            <span>Nổi Ban Ngoài Da</span>
                        </div>
                        <div class="col-lg-2">
                            <span> <form:radiobutton path="rash"></form:radiobutton></span>
                        </div>
                        <div class="col-lg-2">
                            <span><form:radiobutton path="rash"></form:radiobutton></span>
                        </div>
                    </div>
                    <hr>


                </div>

            </div>

        </div>


        <div class="form-row">Lich su phoi nhiem</div>
        <table class="table col-md-12">
            <tr>
                <th class="col-md-8">
                </th>
                <th class="col-md-2 text-center">
                    co
                </th>
                <th class="col-md-2 text-center">
                    khong
                </th>
            </tr>
            <tr>
                <td class="col-md-8">Den Trang trai</td>
                <td class="text-center col-md-2">
                    <form:radiobutton path="visitAny"></form:radiobutton>
                </td>
                <td class="text-center  col-md-2">
                    <form:radiobutton path="visitAny"></form:radiobutton>
                </td>
            </tr>
            <tr>
                <td class="col-md-8">Tiep xuc nguoi benh</td>
                <td class="text-center col-md-2">
                    <form:radiobutton path="careFor"></form:radiobutton>
                </td>
                <td class="text-center col-md-2">
                    <form:radiobutton path="careFor"></form:radiobutton>
                </td>
            </tr>
        </table>
    </div>
    <div class="d-grid gap-2 col-1 mx-auto">
        <button class="btn btn-primary" type="submit">Gửi tờ khai</button>
    </div>

</form:form>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
