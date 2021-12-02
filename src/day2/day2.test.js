const { part1, part2} = require("./index");
const importedData = require("./data.json");
const testData = [
  "forward 5",
  "down 5",
  "forward 8",
  "up 3",
  "down 8",
  "forward 2",
];
describe("Day1", () => {
  it("Should count the numer of times the depth increases", () => {
    expect(part1(testData)).toEqual(150);
  });

  it("Should produce correct result from actual test data", () => {
    expect(part1(importedData)).toEqual(1855814);
  });

  it("Should produce correct result with sliding sum", () => {
    expect(part2(testData)).toEqual(900);
  });

  it("Should produce correct result with sliding sum with actual test data", () => {
    expect(part2(importedData)).toEqual(1845455714);
  });
});
