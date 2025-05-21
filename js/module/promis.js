class Promise {
  constructor(nbfn) {
    nbfn(this.runSucess.bind(this), this.runFail);
  }

  runSucess(ret) {
    this.then(ret);
  }

  runFail(err) {
    this.catch(err);
  }

  then(f) {
    this.thenFn = f;
    return this;
  }

  catch(errFn) {
    this.catchFn = errFn;
  }
}

const promi = (delay) =>
  new Promise((resolve, reject) => {
    setTimeout(resolve, delay, "done!");
  });

promi(1000)
  .then(console.log)
  .catch((err) => console.log("err!! ", err));
