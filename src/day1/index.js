const day1 = (data) => {
  let increases = 0;
  for (let i = 1; i < data.length; i++) {
    if (data[i] > data[i - 1]) {
      increases++;
    }
  }
  return increases;
};

const day1p2 = (data) => {
  let groups = []
  for(let i = 0; i < data.length - 2; i++){
    groups.push(data[i] + data[i+1] + data[i+2])
  }
  return day1(groups);
};
module.exports = { day1, day1p2 };
