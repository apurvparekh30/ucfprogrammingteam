TweenMax.set('#header', {alpha: 0})
TweenMax.set('#bridge', {alpha: 0})
TweenMax.set('#header1', {alpha: 0})
TweenMax.set('.f3', {alpha: 0})
TweenMax.set('#anthem', {alpha: 0})

function goAnim () {
  TweenMax.set('#header', {alpha: 1})
  TweenMax.set('#bridge', {alpha: 1})
  TweenMax.set('#header1', {alpha: 1})
  TweenMax.set('.f3', {alpha: 1})
  TweenMax.set('#anthem', {alpha: 1})

  TweenMax.from('#anthem', 1, {alpha: 0, ease: Power4.easeIn})
  TweenMax.from('#header', 1, {alpha: 0, ease: Power4.easeOut, delay: 1})
  TweenMax.set('#bridge', {display: 'block', delay: 1.8})
  TweenMax.from('#bridge', 1, {alpha: 0, ease: Power4.easeOut, delay: 2})
  TweenMax.staggerFrom(['#one', '#two', '#three', '#four', '#five', '#six', '#seven', '#eight', '#nine'], 0.15, {
    scaleY: 0,
    transformOrigin: 'bottom',
    ease: Power1.easeOut,
    delay: 2
  }, 0.075)
  TweenMax.from('#header1', 1, {alpha: 0, ease: Power4.easeOut, delay: 3})

  TweenMax.to('#header', 1, {alpha: 0, delay: 5})
  TweenMax.to('#bridge', 1, {alpha: 0, delay: 5})
  TweenMax.to('#header1', 1, {alpha: 0, delay: 5})
  TweenMax.to('#logo', 1, {y: -8, ease: Power4.easeIn, delay: 5.6})

  TweenMax.set('#header', {display: 'none', delay: 6})
  TweenMax.set('#bridge', {display: 'none', delay: 6})
  TweenMax.set('#header1', {display: 'none', delay: 6})

  TweenMax.from('.f3', 1, {alpha: 0, ease: Power0.easeOut, delay: 6.2})
}

goAnim()
