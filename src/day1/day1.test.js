const { day1, day1p2 } = require("./index");
const importedData = require("./data.json");
const testData = [199, 200, 208, 210, 200, 207, 240, 269, 260, 263];
describe("Day1", () => {
  it("Should count the numer of times the depth increases", () => {
    expect(day1(testData)).toEqual(7);
  });

  it("Should produce correct result from actual test data", () => {
    expect(day1(importedData)).toEqual(1754);
  });

  it("Should produce correct result with sliding sum", () => {
    expect(day1p2(testData)).toEqual(5);
  });

  it("Should produce correct result with sliding sum with actual test data", () => {
    expect(day1p2(importedData)).toEqual(1789);
  });
});
