type Point = { x: number; y: number };
let newPoint: Point = {x:1, y:2};
type P = keyof Point;
let test: P = 'x';
let newTest: P = 'y';
let anotherTest: P = 'z';

console.log(test.toString());
console.log();