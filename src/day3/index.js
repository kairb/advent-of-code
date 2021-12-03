const part1 = (data) => {
  let gammaRate = "";
  let epsilonRate = "";
  let zeros = 0;
  let ones = 0;
  for (let i = 0; i < data[0].length; i++) {
    for (let j = 0; j < data.length; j++) {
      if (data[j][i] === "0") {
        zeros += 1;
      } else {
        ones += 1;
      }
    }
    if (zeros > ones) {
      gammaRate += "0";
      epsilonRate += "1";
    } else {
      gammaRate += "1";
      epsilonRate += "0";
    }
    zeros = 0;
    ones = 0;
  }
  gammaRate = parseInt(gammaRate, 2);
  epsilonRate = parseInt(epsilonRate, 2);
  return gammaRate * epsilonRate;
};

const part2 = (data) => {
  let oxygen = [...data];
  let carbon = [...data];
  let zeros = 0;
  let ones = 0;
  for (let i = 0; i < oxygen[0].length; i++) {
    for (let j = 0; j < oxygen.length; j++) {
      if (oxygen[j][i] === "0") {
        zeros += 1;
      } else {
        ones += 1;
      }
    }
    for (let k = 0; k < oxygen.length; k++) {
      if(carbon.length === 1){
        break;
      }
      if (zeros > ones && oxygen[k][i] === "1") {
        oxygen.splice(k, 1);
        k--
      } else if (zeros < ones && oxygen[k][i] === "0") {
        oxygen.splice(k, 1);
        k--
      } else if (zeros === ones && oxygen[k][i] === "0") {
        oxygen.splice(k, 1);
        k--
      }
    }
    zeros = 0;
    ones = 0;
  }
  for (let a = 0; a < carbon[0].length; a++) {
    for (let b = 0; b < carbon.length; b++) {
      if (carbon[b][a] === "0") {
        zeros += 1;
      } else {
        ones += 1;
      }
    }

    for (let c = 0; c < carbon.length; c++) {
      if(carbon.length === 1){
        break;
      }
      if (zeros > ones && carbon[c][a] === "0") {
        carbon.splice(c, 1);
        c--;
      } else if (zeros < ones && carbon[c][a] === "1") {
        carbon.splice(c, 1);
        c--;
      } else if (zeros === ones && carbon[c][a] === "1") {
        carbon.splice(c, 1);
        c--;
      }
    }
    zeros = 0;
    ones = 0;
  }
  oxygen = parseInt(oxygen[0], 2);
  carbon = parseInt(carbon[0], 2);
  return oxygen * carbon;
};

module.exports = { part1, part2 };
