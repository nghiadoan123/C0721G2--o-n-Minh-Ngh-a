#Hiển thị danh sách tất cả học viên
SELECT *
FROM student;

#Hiển thị danh sách học viên đang theo học
SELECT *
FROM student
WHERE s_tatus = true;

#Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ.
SELECT *
FROM Subject
WHERE credit < 10;

#Hiển thị danh sách học viên lớp A1
SELECT S.student_id, S.student_name, C.class_name
FROM student S join class C on S.class_id = C.class_id
WHERE C.class_name = 'A1';

#Hiển thị điểm môn CF của các học viên.
SELECT S.student_id, S.student_name, Sub.sub_name, M.mark
FROM student as S join mark as M on S.student_id = M.student_id join subject Sub on M.sub_id = Sub.sub_id
WHERE Sub.sub_name = 'CF';