const part1 = (data) => {
  let horizontal = 0;
  let depth = 0;
  data.forEach(instruction => {
    let [direction, number] = instruction.trim().split(' ');
    number = Number.parseInt(number);
    if (direction === "forward"){
      horizontal += number;
    }else if( direction === "up"){
      depth -= number;
    }else{
      depth += number;
    }
  });
  return horizontal * depth;
};

const part2 = (data) => {
  let horizontal = 0;
  let depth = 0;
  let aim = 0;
  data.forEach(instruction => {
    let [direction, number] = instruction.trim().split(' ');
    number = Number.parseInt(number);
    if (direction === "forward"){
      horizontal += number;
      depth += aim * number;
    }else if( direction === "up"){
      aim -= number;
    }else{
      aim += number;
    }
  });
  return horizontal * depth;
};
module.exports = { part1, part2};
