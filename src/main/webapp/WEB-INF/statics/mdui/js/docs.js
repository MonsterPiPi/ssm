// 浠ｇ爜楂樹寒
hljs.initHighlightingOnLoad();

// 椤甸潰婊氬姩
smoothScroll.init({
    speed: 300
});

// 鍥剧墖鍗犱綅绗�
Holder.addTheme("gray", {
    bg: "#BCBEC0",
    fg: "rgba(255, 255, 255, 1)",
    size: 12,
    fontweight: "normal"
});

// 绀轰緥澶勭悊
$$('.viewsource').on('click', function () {
    var $this = $$(this);
    $this.parents('.doc-example').eq(0).toggleClass('doc-example-showcode');
});


/**
 * 璁剧疆鏂囨。涓婚
 */
(function () {
    var DEFAULT_PRIMARY = 'indigo';
    var DEFAULT_ACCENT = 'pink';
    var DEFAULT_LAYOUT = '';

    // 璁剧疆 cookie
    var setCookie = function (key, value) {
        // cookie 鏈夋晥鏈熶负 1 骞�
        var date = new Date();
        date.setTime(date.getTime() + 365*24*3600*1000);
        document.cookie = key + '=' + value + '; expires=' + date.toGMTString() + '; path=/';
    };

    var setDocsTheme = function (theme) {
        if (typeof theme.primary === 'undefined') {
            theme.primary = false;
        }
        if (typeof theme.accent === 'undefined') {
            theme.accent = false;
        }
        if (typeof theme.layout === 'undefined') {
            theme.layout = false;
        }

        var i, len;
        var $body = $$('body');

        var classStr = $body.attr('class');
        var classs = classStr.split(' ');

        // 璁剧疆涓昏壊
        if (theme.primary !== false) {
            for (i = 0, len = classs.length; i < len; i++) {
                if (classs[i].indexOf('mdui-theme-primary-') === 0) {
                    $body.removeClass(classs[i])
                }
            }
            $body.addClass('mdui-theme-primary-' + theme.primary);
            setCookie('docs-theme-primary', theme.primary);
            $$('input[name="doc-theme-primary"][value="' + theme.primary + '"]').prop('checked', true);
        }

        // 璁剧疆寮鸿皟鑹�
        if (theme.accent !== false) {
            for (i = 0, len = classs.length; i < len; i++) {
                if (classs[i].indexOf('mdui-theme-accent-') === 0) {
                    $body.removeClass(classs[i]);
                }
            }
            $body.addClass('mdui-theme-accent-' + theme.accent);
            setCookie('docs-theme-accent', theme.accent);
            $$('input[name="doc-theme-accent"][value="' + theme.accent + '"]').prop('checked', true);
        }

        // 璁剧疆涓婚鑹�
        if (theme.layout !== false) {
            for (i = 0, len = classs.length; i < len; i++) {
                if (classs[i].indexOf('mdui-theme-layout-') === 0) {
                    $body.removeClass(classs[i]);
                }
            }
            if (theme.layout !== '') {
                $body.addClass('mdui-theme-layout-' + theme.layout);
            }
            setCookie('docs-theme-layout', theme.layout);
            $$('input[name="doc-theme-layout"][value="' + theme.layout + '"]').prop('checked', true);
        }
    };

    // 鍒囨崲涓昏壊
    $$(document).on('change', 'input[name="doc-theme-primary"]', function () {
        setDocsTheme({
            primary: $$(this).val()
        });
    });

    // 鍒囨崲寮鸿皟鑹�
    $$(document).on('change', 'input[name="doc-theme-accent"]', function () {
        setDocsTheme({
            accent: $$(this).val()
        });
    });

    // 鍒囨崲涓婚鑹�
    $$(document).on('change', 'input[name="doc-theme-layout"]', function () {
        setDocsTheme({
            layout: $$(this).val()
        });
    });

    // 鎭㈠榛樿涓婚
    $$(document).on('cancel.mdui.dialog', '#dialog-docs-theme', function () {
        setDocsTheme({
            primary: DEFAULT_PRIMARY,
            accent: DEFAULT_ACCENT,
            layout: DEFAULT_LAYOUT
        });
    });
})();
