
const run = () => {
    console.log('this is tarun');
    setTimeout(() => run(), 2000);
}
run();