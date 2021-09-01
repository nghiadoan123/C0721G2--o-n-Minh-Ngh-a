let input_physics;
let input_chemistry;
let input_biology;
input_physics = prompt("Enter the input physics");
input_chemistry = prompt("Enter the input chemistry");
input_biology = prompt("Enter the input biology");
let physics = parseInt(input_physics);
let chemistry = parseInt(input_chemistry);
let biology = parseInt(input_biology);
let average = (physics + chemistry + biology)/3;
document.write("Average is: " + average);

//
