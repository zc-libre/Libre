import {defineConfig, loadEnv} from 'vite'
import vue from '@vitejs/plugin-vue'
import {createSvgIconsPlugin} from 'vite-plugin-svg-icons'
import {createHtmlPlugin} from 'vite-plugin-html-transformer'
import path from 'path'

// https://vitejs.dev/config/
export default ({mode}) => {
  process.env = {...process.env, ...loadEnv(mode, process.cwd())}
  const filenamePath =
    process.env.VITE_MODE === 'production'
      ? 'index.html'
      : 'index.html'
  const templatePath =
    process.env.VITE_MODE === 'production'
      ? 'public/index.html'
      : 'public/index.html'

  return defineConfig({
    base: './',
    build: {
      outDir: 'dist',
      assetsDir: 'static',
      rollupOptions: {
        output: {
          assetFileNames: assetInfo => {
            let extType = assetInfo.name.split('.').at(1)
            if (/png|jpe?g|svg|gif|tiff|bmp|ico/i.test(extType)) {
              extType = 'img'
            }
            return `static/${extType}/[hash][extname]`
          },
          chunkFileNames: 'static/js/[hash].js',
          entryFileNames: 'static/js/[hash].js'
        },
        plugins: []
      }
    },
    plugins: [
      createSvgIconsPlugin({
        // Specify the icon folder to be cached
        iconDirs: [path.resolve(process.cwd(), 'src/icons')],
        // Specify symbolId format
        symbolId: 'icon-[dir]-[name]',

        /**
         * custom insert position
         * @default: body-last
         */
        // inject: 'body-last' | 'body-first',

        /**
         * custom dom id
         * @default: __svg__icons__dom__
         */
        customDomId: '__svg__icons__dom__'
      }),
      createHtmlPlugin({
        minify: true,
        entry: '/src/main.ts',
        filename: filenamePath,
        template: templatePath
      }),
      vue(),
    ],
    resolve: {
      alias: {
        '@': path.resolve(__dirname, './src')
      },
      extensions: ['.mjs', '.js', '.ts', '.jsx', '.tsx', '.json', '.vue']
    },
    server: {
      host: '0.0.0.0',
      proxy: {
        '/web': {
          target: process.env.VUE_APP_BASE_API,
          changeOrigin: true,
          rewrite: path => path.replace(/^\/web/, 'web')
        }
      }
    }
  })
}
