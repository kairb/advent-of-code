const { part1, part2 } = require("./index");
const importedData = require("./data.json");
const testData = [
  '00100', '11110', '10110', '10111', '10101', '01111', '00111', '11100', '10000', '11001', '00010',
  '01010',
];
describe("Day1", () => {
  it("Should get correct answer from test data", () => {
    expect(part1(testData)).toEqual(198);
  });

  it("Should produce correct result from actual data", () => {
    expect(part1(importedData)).toEqual(3549854);
  });

  it("Should get correct answer from test data", () => {
    expect(part2(testData)).toEqual(230);
  });

  it("Should produce correct result with sliding sum with actual test data", () => {
    expect(part2(importedData)).toEqual(3765399);
  });
});
